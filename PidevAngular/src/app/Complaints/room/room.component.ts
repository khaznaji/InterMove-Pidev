import { Component, OnInit } from '@angular/core';
import { RoomService } from 'src/app/shared/room.service';
import { MessageType } from '../../model/Complaints/message-type';
import { ChatMessage } from 'src/app/model/Complaints/chat-message.model';
@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styles: [
  ]
})
export class RoomComponent  implements OnInit {
 topic = 'default';
  username = '';
  messages: ChatMessage[] = [];
  messageContent = '';

  constructor(private chatService: RoomService) { }

  ngOnInit(): void {
    this.chatService.connect(this.topic);
    this.chatService.getMessages(this.topic).subscribe(
      (message: ChatMessage) => {
        this.messages.push(message);
      },
      (error: any) => console.error(error)
    );
  }

  ngOnDestroy(): void {
    this.chatService.disconnect();
  }

  sendMessage(): void {
   const  chatMessage: ChatMessage = {
      type: MessageType.CHAT,
      topic: this.topic,
      content: this.messageContent,
      sender: this.username
    };
    this.chatService.sendMessage(this.topic, chatMessage);
    this.messageContent = '';
  }


  


}
