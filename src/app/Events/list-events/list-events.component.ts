import { Component, OnInit } from '@angular/core';
import { Event } from '../../model/Event/event.model';
import { EventsService } from '../../shared/event.service';
import { Observable } from "rxjs";


@Component({
  selector: 'app-list-events',
  templateUrl: './list-events.component.html',
})
export class ListEventsComponent implements OnInit {

  events!: Observable<Event[]>;

  constructor(private eventsService: EventsService) { }

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.events = this.eventsService.getEvents();
  }

  deleteEvent(id: number): void {
    this.eventsService.deleteEvent(id).subscribe({
      next: response => console.log(response),
      error: error => console.log(error),
      complete: () => console.log('Delete request completed.')
    });
  }
  
  

}
