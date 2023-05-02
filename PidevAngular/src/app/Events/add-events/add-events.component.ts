import { Component } from '@angular/core';
import { EventsService } from '../../shared/event.service';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Event } from '../../model/Event/event.model';

@Component({
  selector: 'app-add-events',
  templateUrl: './add-events.component.html',
  
})
export class AddEventsComponent implements OnInit {

  events: Event = new Event();
  submitted = false;

  constructor(private eventsService: EventsService,
    private router: Router) { }

    map: any;

    ngOnInit() {
      
    }

  newEmployee(): void {
    this.submitted = false;
    this.events = new Event();
  }

  save() {
    this.eventsService
      .createEvent(this.events)
      .subscribe({
        next: data => {
          console.log(data);
          this.events = new Event();
          this.gotoList();
        },
        error: error => console.log(error)
      });
  }
  

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/listEvents']);
  }
  onFileSelected(event: any) {
    const file = event.target.files[0];
    this.events.image = file.name;
  }

  onFileSelected2(event: any) {
    const file = event.target.files[0];
    this.events.speaker = file.name;
  }
  }
  
