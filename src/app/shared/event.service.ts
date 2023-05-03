
import { ModaliteEvent } from '../model/Event/modalite-event';
import { TypeEvent } from '../model/Event/type-event';

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventsService {

  private BASE_URL = 'http://localhost:8060/InterMove/Events/list';
  private BASE_URL2 = 'http://localhost:8060/InterMove/Events/add';
  private BASE_URL3= "http://localhost:8060/InterMove/Events/delete"
  constructor(private http: HttpClient) { }

  getEvents(): Observable<any> {
    return this.http.get(`${this.BASE_URL}`);
  }

deleteEvent(id: number): Observable<any> {
  return this.http.delete(`${this.BASE_URL3}/${id}`, { responseType: 'text' });
}
createEvent(employee: Object): Observable<Object> {
  return this.http.post(`${this.BASE_URL2}`, employee);
}

}