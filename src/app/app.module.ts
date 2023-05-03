import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { AddEventsComponent } from './Events/add-events/add-events.component';
import { ListEventsComponent } from './Events/list-events/list-events.component';
import { AddComplaintsComponent } from './Complaints/add-complaints/add-complaints.component';
import { ListComplaintsComponent } from './Complaints/list-complaints/list-complaints.component';
import { HttpClientModule } from '@angular/common/http';
import { MenuFrontComponent } from './menu-front/menu-front.component';
import { ListQuizComponent } from './quiz/list-quiz/list-quiz.component';
import { QuestionComponent } from './quiz/question/question.component';
import { QuizComponent } from './userQuiz/quiz/quiz.component';
import {QuestionComponent as userQuestionComponent} from './userQuiz/question/question.component'

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    AddEventsComponent,
    ListEventsComponent,
    AddComplaintsComponent,
    ListComplaintsComponent,
    MenuFrontComponent,
    ListQuizComponent,
    userQuestionComponent,
    QuestionComponent,
    QuizComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
     
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
