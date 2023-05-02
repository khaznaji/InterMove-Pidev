import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { webSocket, WebSocketSubject } from 'rxjs/webSocket';
import { ChatMessage } from '../model/Complaints/chat-message.model';
import * as SockJS from 'sockjs-client';
import { Stomp } from '@stomp/stompjs';
import { RoomComponent } from '../Complaints/room/room.component';
@Injectable({
  providedIn: 'root'
})
export class RoomService {
    private webSocketSubject!: WebSocketSubject<any>;

    constructor() { }

    connect(topic: string): void {
      const webSocketUrl = `ws://localhost:8060/InterMove/chat/`;
      this.webSocketSubject = webSocket(webSocketUrl);
    }
    
    disconnect(): void {
      this.webSocketSubject.complete();
    }

    sendMessage(topic: string, chatMessage: ChatMessage): void {
      this.webSocketSubject.next({
        topic: topic,
        type: chatMessage.type,
        content: chatMessage.content,
        sender: chatMessage.sender
      });
    }

    addUser(topic: string, chatMessage: ChatMessage): void {
      this.webSocketSubject.next({
        topic: topic,
        type: chatMessage.type,
        sender: chatMessage.sender
      });
    }

    getMessages(topic: string): Observable<ChatMessage> {
      return this.webSocketSubject.asObservable();
    } 
    
}
