import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListComplaintsComponent } from './Complaints/list-complaints/list-complaints.component';
import { ListEventsComponent } from './Events/list-events/list-events.component';
import { AddComplaintsComponent } from './Complaints/add-complaints/add-complaints.component';
import { AddEventsComponent } from './Events/add-events/add-events.component';
import { MenuComponent } from './menu/menu.component';
import { MenuFrontComponent } from './menu-front/menu-front.component';
import { UpdateEventComponent } from './Events/update-event/update-event.component';
import { UpdateComplaintsComponent } from './Complaints/update-complaints/update-complaints.component';
import { QrcodeComponent } from './Qrcode/qrcode/qrcode.component';
import { ListEventsFrontComponent } from './Events/list-events-front/list-events-front.component';
import { VideochatComponent } from './Events/videochat/videochat.component';
import { ListUserComplaintsComponent } from './Complaints/list-user-complaints/list-user-complaints.component';
import { RoomComponent } from './Complaints/room/room.component';
import { WeatherComponent } from './Events/weather/weather.component';
import { DetailEventComponent } from './Events/detail-event/detail-event.component';


const routes: Routes = [
  { path :'room',component: RoomComponent} , 
  { path :'weather',component: WeatherComponent} , 

  { path :'front',component: MenuFrontComponent, children : [
    { path :'addComplaints',component: AddComplaintsComponent} , 
    { path :'editComplaints/:id',component: UpdateComplaintsComponent} , 
    { path :'listEvent',component: ListEventsFrontComponent} , 
    { path :'listComplaints',component: ListUserComplaintsComponent} , 
    { path: 'detailevent/:id', component: DetailEventComponent }




   
   ]},

  {path : '', component:MenuComponent, children : [
 { path :'listEvents',component: ListEventsComponent} , 
 { path :'listComplaints',component: ListComplaintsComponent} , 
 { path :'addEvent',component: AddEventsComponent} , 
 { path :'editEvent/:id',component: UpdateEventComponent}]},
 { path :'qrcode',component: QrcodeComponent} ,
 { path :'video',component: VideochatComponent} , 





];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
