package com.example.intermove.Forum.Controller;


import com.example.intermove.Forum.Services.MessageService;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<com.example.intermove.Entities.Forum.Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{messageID}")
    public Message getMessageById(@PathVariable Long messageID) {
        return (Message) messageService.getMessageById(messageID);
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return (Message) messageService.createMessage((com.example.intermove.Entities.Forum.Message) message);
    }

    @PutMapping("/{messageID}")
    public Message updateMessage(@PathVariable Long messageID, @RequestBody Message messageDetails) {
        return (Message) messageService.updateMessage(messageID, (com.example.intermove.Entities.Forum.Message) messageDetails);
    }

    @DeleteMapping("/{messageID}")
    public void deleteMessage(@PathVariable Long messageID) {
        messageService.deleteMessage(messageID);
    }
}


