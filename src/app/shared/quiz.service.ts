import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Quizz } from '../model/Quizz/quizz.model';
import { Question } from '../model/Quizz/question';

@Injectable({
  providedIn: 'root'
})
export class QuizService {


  private BASE_URL = 'http://localhost:8060/InterMove/';
  constructor(private http: HttpClient) { }

  getQuiz(): Observable<any> {
    return this.http.get(`${this.BASE_URL}`+"quiz/displayQuiz");
  }
  getQuizScoreByUser(id:number): Observable<any> {
    return this.http.get(`${this.BASE_URL}`+"user/retrieve-user/"+id);
  }
getQuizdiplayShuffledQuestionOfQuiz(id:number): Observable<any> {
    return this.http.get(`${this.BASE_URL}`+"quiz/diplayShuffledQuestionOfQuiz/"+id);
}
deleteQuiz(id: number): Observable<any> {
  return this.http.delete(`${this.BASE_URL}quiz/deleteQuiz/${id}`, { responseType: 'text' });
}
createQuiz(quiz: Object): Observable<any> {
  return this.http.post(`${this.BASE_URL}`+"quiz/addQuiz", quiz);
}
updateQuiz(quiz: Quizz): Observable<any> {
  return this.http.put(this.BASE_URL + 'quiz/updateQuiz', quiz);
}
addQuestionToQuiz(question: Question,id:number): Observable<any> {
  return this.http.post(this.BASE_URL + 'quiz/addQuestionToQuiz/'+id ,question);
}
getQuestion(): Observable<any> {
  return this.http.get(`${this.BASE_URL}`+"quiz/displayQuestion");
}
updateQuestion(question: Question): Observable<any> {
  return this.http.put(this.BASE_URL + 'quiz/updateQuestion', question);
}
deleteQuestion(id: number): Observable<any> {
  return this.http.delete(`${this.BASE_URL}quiz/deleteQuestion/${id}`, { responseType: 'text' });
}
addResponseToQuestion(questionId: number, userId: number, response: any): Observable<any> {
  return this.http.post(`${this.BASE_URL}quiz/addResponseToQuestion/${questionId}/${userId}`, response);
}
}
