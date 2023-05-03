import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListComplaintsComponent } from './Complaints/list-complaints/list-complaints.component';

import { ListEventsComponent } from './Events/list-events/list-events.component';
import { AddComplaintsComponent } from './Complaints/add-complaints/add-complaints.component';
import { AddEventsComponent } from './Events/add-events/add-events.component';
import { MenuComponent } from './menu/menu.component';
import { MenuFrontComponent } from './menu-front/menu-front.component';

import { ListQuizComponent } from './quiz/list-quiz/list-quiz.component';
import { QuestionComponent } from './quiz/question/question.component';
import {QuestionComponent as userQuestionComponent} from './userQuiz/question/question.component';
import { QuizComponent } from './userQuiz/quiz/quiz.component';

const routes: Routes = [
  { path :'front',component: MenuFrontComponent} , 
  { path :'userQuiz',component: QuizComponent} ,
  { path :'userQuestion/:id',component: userQuestionComponent} ,

{path : '', component:MenuComponent, children : [
 { path :'listEvents',component: ListEventsComponent} , 
 { path :'listComplaints',component: ListComplaintsComponent} , 
 { path :'addComplaints',component: AddComplaintsComponent} , 
 { path :'addEvent',component: AddEventsComponent} ,
 { path :'listQuiz',component: ListQuizComponent}  , 
 { path :'listQuestion',component: QuestionComponent}
]
},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
