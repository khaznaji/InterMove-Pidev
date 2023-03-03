package com.example.intermove.Quiz.Services;

import com.example.intermove.Entities.Quizz.Question;
import com.example.intermove.Entities.Quizz.Quiz;
import com.example.intermove.Entities.Quizz.Response;
import com.example.intermove.Entities.Quizz.ResponseStatus;
import com.example.intermove.Entities.User.Badge;
import com.example.intermove.Entities.User.User;
import com.example.intermove.Quiz.Repositoryy.QuestionRepository;
import com.example.intermove.Quiz.Repositoryy.QuizRepository;
import com.example.intermove.Quiz.Repositoryy.ResponseRepository;
import com.example.intermove.Quiz.Repositoryy.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServiceQuiz implements IServiceQuiz {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final ResponseRepository responseRepository;
    private final UserRepository userRepository;

    public ServiceQuiz(QuizRepository quizRepository, QuestionRepository questionRepository, ResponseRepository responseRepository,UserRepository userRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.responseRepository = responseRepository;
        this.userRepository=userRepository;
    }

    @Override
    public void addQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    @Override
    public void addQuestionToQuiz(Integer quizId, Question question) {
        Quiz quiz = quizRepository.findById(quizId).orElse(null);
        if(quiz.getQuestions()!=null){
            int restpoint=quiz.getScore()-quiz.getQuestions().stream().mapToInt(q->q.getQuestionNote()).sum();
            if(restpoint-question.getQuestionNote()>=0){
                question.setQuiz(quiz);
                questionRepository.save(question);
                System.out.println("ajout question avec success");
            }
            else{
                System.out.println("On peut pas ajouter");
            }

        }
        else{
            if(quiz.getScore()-question.getQuestionNote()>=0){
                question.setQuiz(quiz);
                questionRepository.save(question);
                System.out.println("ajout question avec success");
            }
            else{
                System.out.println("On peut pas ajouter");
            }
        }


    }
    @Override
    public void addResponseToQuestion(Integer questionId, List<String> studentResponses, int studentId) {
        Question question = questionRepository.findById(questionId).orElse(null);
        User student=userRepository.findById(studentId).orElse(null);
        Response response = new Response();
        response.setStudent(student);
        response.setQuestion(question);
        response.setStudentResponses(studentResponses);

        Set<Integer> correctResponses = question.getCorrectResponsesIndex();
        double score = calculateScore(studentResponses, question);
        student.setScore(student.getScore()+score);
        response.setScore(score);
        response.setStatus(getResponseStatus(score, correctResponses.size(),question.getQuestionNote()));

        responseRepository.save(response);
    }

    @Override
    public List<Quiz> displayQuiz() {
        return quizRepository.findAll();
    }

    @Override
    public List<Question> displayQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public List<Response> displayResponse() {
        return responseRepository.findAll();
    }

    @Override
    public void deleteQuiz(Integer idQuiz) {
        quizRepository.deleteById(idQuiz);
    }

    @Override
    public void deleteQuestion(Integer idQuestion) {
        questionRepository.deleteById(idQuestion);
    }

    @Override
    public void updateQuiz(Quiz quiz) {
        Quiz q=quizRepository.findById(quiz.getId()).orElse(null);
        if(q.getQuestions()!=null){
            quiz.setQuestions(q.getQuestions());
        }
        quizRepository.save(quiz);
    }

    @Override
    public void updateQuestion(Question question) {
        Question q=questionRepository.findById(question.getId()).orElse(null);
        if(q.getStudentResponses()!=null){
            question.setResponses(q.getResponses());
        }
        question.setQuiz(q.getQuiz());
        questionRepository.save(question);
    }

    private double calculateScore(List<String> studentResponses, Question question) {
        List<String> correctAnswers = new ArrayList<>();

        List<Integer> correct=new ArrayList<>(question.getCorrectResponsesIndex());
        Collections.sort(correct);
        System.out.println(correct);
        for (int i : correct) {

                correctAnswers.add(question.getResponses().get(i));

        }

        System.out.println("***************");
        System.out.println(studentResponses);
        System.out.println(correctAnswers);
        int count = 0;
        for (String str1 : correctAnswers) {
            for (String str2 : studentResponses) {
                if (str1.equals(str2)) {
                    count++;
                    break;
                }
            }
        }
        double result=((double) count / correctAnswers.size() * question.getQuestionNote());

        return result;
    }

    private ResponseStatus getResponseStatus(double score, int numCorrectResponses, int note) {
        if (score == 0) {
            return ResponseStatus.INCORRECT;
        } else if (score < note) {
            return ResponseStatus.PARTIAL;
        } else {
            return ResponseStatus.CORRECT;
        }
    }
    //randomize question and response
    public List<Question> shuffleResponses(int idQuiz) {
        List<Question> result=new ArrayList<>();
        Quiz quiz=quizRepository.findById(idQuiz).orElse(null);
        for (Question question : quiz.getQuestions()) {
            List<String> responses = question.getResponses();
            Set<Integer> correctResponsesIndex = question.getCorrectResponsesIndex();
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < responses.size(); i++) {
                indices.add(i);
            }
            Collections.shuffle(indices);
            List<String> shuffledResponses = new ArrayList<>();
            Set<Integer> shuffledCorrectResponsesIndex = new HashSet<>();
            for (int i = 0; i < indices.size(); i++) {
                int index = indices.get(i);
                shuffledResponses.add(responses.get(index));
                if (correctResponsesIndex.contains(index)) {
                    shuffledCorrectResponsesIndex.add(i);
                }
            }
            question.setResponses(shuffledResponses);
            question.setCorrectResponsesIndex(shuffledCorrectResponsesIndex);
            result.add(question);
        }
        Collections.shuffle(result);
        return (result);
    }
    public List<User> getUsersByScore() {
        List<User> users= userRepository.findAll().stream().sorted(Comparator.comparing(User::getScore)).collect(Collectors.toList());
        List<User> sortedList=new ArrayList<>();
        ListIterator<User> listIterator=users.listIterator(users.size());
        while(listIterator.hasPrevious()){
            sortedList.add(listIterator.previous());
        }
        return sortedList;
    }
    @Scheduled(cron ="*/30 * * * * *")
    public void GetBadge(){
        List<User> users= userRepository.findAll();
        for(User u:users){
            if(u.getScore()>5000){
                u.setBadge(Badge.PLATINUM);
            }
            else if(u.getScore()>3000 && u.getScore()<5000){
                u.setBadge(Badge.GOLD);
            }
            else if(u.getScore()>700 && u.getScore()<3000){
                u.setBadge(Badge.SILVER);
            }
            else{
                u.setBadge(Badge.BRONZE);
            }
            userRepository.save(u);
        }
    }

}
