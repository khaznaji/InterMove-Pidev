package com.example.intermove.Quiz.Services;


import com.example.intermove.Entities.Quizz.Question;
import com.example.intermove.Entities.Quizz.Quiz;
import com.example.intermove.Entities.Quizz.Response;
import com.example.intermove.Entities.User.User;

import java.util.List;

public interface IServiceQuiz {
    void addQuiz(Quiz quiz);
    void addQuestionToQuiz(Integer quizId, Question question);
    void addResponseToQuestion(Integer questionId, List<String> studentResponses, int studentId) ;
    List<Quiz> displayQuiz();
    List<Question> displayQuestion();
    List<Response> displayResponse();
    void deleteQuiz(Integer idQuiz);
    void deleteQuestion(Integer idQuestion);
    void updateQuiz(Quiz quiz);
    void updateQuestion(Question question);
    public List<Question> shuffleResponses(int idQuiz);
    List<User> getUsersByScore();
}
