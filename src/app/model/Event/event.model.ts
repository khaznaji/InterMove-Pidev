import { User } from '../User/user';
import { ModaliteEvent } from '../Event/modalite-event';
import { TypeEvent } from '../Event/type-event';
export class Event {
    id: number;
    title: string;
    description: string;
    dateD: Date;
    dateF: Date;
    nbreDePlaces: number;
    image: string;
    speaker: string;
    typeEvent: TypeEvent;
    modaliteEvent: ModaliteEvent;
    users: User[];
  
    constructor(
      id: number,
      title: string,
      description: string,
      dateD: Date,
      dateF: Date,
      nbreDePlaces: number,
      image: string,
      speaker: string,
      typeEvent: TypeEvent,
      modaliteEvent: ModaliteEvent,
      users: User[]
    ) {
      this.id = id;
      this.title = title;
      this.description = description;
      this.dateD = dateD;
      this.dateF = dateF;
      this.nbreDePlaces = nbreDePlaces;
      this.image = image;
      this.speaker = speaker;
      this.typeEvent = typeEvent;
      this.modaliteEvent = modaliteEvent;
      this.users = users;
    }
   
  }
