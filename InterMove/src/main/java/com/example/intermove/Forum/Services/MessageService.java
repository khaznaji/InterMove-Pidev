package com.example.intermove.Forum.Services;


import com.example.intermove.Entities.Forum.Message;
import com.example.intermove.Forum.Controller.ResourceNotFoundException;
import com.example.intermove.Forum.Repositoryy.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(Long messageID) {
        return messageRepository.findById(messageID)
                .orElseThrow(() -> new ResourceNotFoundException("Message", "messageID", messageID));
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message updateMessage(Long messageID, Message messageDetails) {
        Message message = getMessageById(messageID);
        message.setContent(messageDetails.getContent());
        message.setSent_at(messageDetails.getSent_at());
        return messageRepository.save(message);
    }

    public void deleteMessage(Long messageID) {
        messageRepository.deleteById(messageID);
    }
}
