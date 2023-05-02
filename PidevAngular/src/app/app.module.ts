import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { AddEventsComponent } from './Events/add-events/add-events.component';
import { ListEventsComponent } from './Events/list-events/list-events.component';
import { AddComplaintsComponent } from './Complaints/add-complaints/add-complaints.component';
import { ListComplaintsComponent } from './Complaints/list-complaints/list-complaints.component';
import { HttpClientModule } from '@angular/common/http';
import { MenuFrontComponent } from './menu-front/menu-front.component';
import { UpdateEventComponent } from './Events/update-event/update-event.component';
import { UpdateComplaintsComponent } from './Complaints/update-complaints/update-complaints.component';
import { QrcodeComponent } from './Qrcode/qrcode/qrcode.component';
import { VideochatComponent } from './Events/videochat/videochat.component';
import { VideochatPageComponent } from './Events/videochat-page/videochat-page.component';
import { ListEventsFrontComponent } from './Events/list-events-front/list-events-front.component';
import { EmbedVideoService } from 'ngx-embed-video';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { ListUserComplaintsComponent } from './Complaints/list-user-complaints/list-user-complaints.component';
import { RoomComponent } from './Complaints/room/room.component';
import { NgxFileDropModule } from 'ngx-file-drop';
import { NgxPaginationModule } from 'ngx-pagination';
import { WeatherComponent } from './Events/weather/weather.component';
import { DetailEventComponent } from './Events/detail-event/detail-event.component';
import { ToastrModule } from 'ngx-toastr';
import { Component, NO_ERRORS_SCHEMA } from '@angular/core';
import { MatNativeDateModule } from '@angular/material/core';

import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    AddEventsComponent,
    ListEventsComponent,
    AddComplaintsComponent,
    ListComplaintsComponent,
    MenuFrontComponent,
    UpdateEventComponent,
    UpdateComplaintsComponent,
    QrcodeComponent,
    VideochatComponent,
    VideochatPageComponent,
    ListEventsFrontComponent,
    ListUserComplaintsComponent,
    RoomComponent,
    WeatherComponent,
    DetailEventComponent,

  ],
  schemas: [NO_ERRORS_SCHEMA],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    HttpClientModule,
    FormsModule,ReactiveFormsModule, 
    MatFormFieldModule, MatSelectModule, NgxFileDropModule,NgxPaginationModule,
    ToastrModule.forRoot(),    BrowserAnimationsModule,
    MatDatepickerModule,
    MatInputModule,    MatNativeDateModule,



     
  ],
  providers: [EmbedVideoService], // Add the EmbedVideoService here
  bootstrap: [AppComponent]
})
export class AppModule { }




