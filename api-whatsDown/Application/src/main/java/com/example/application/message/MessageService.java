package com.example.application.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // same as @Component functionally but this adds readability
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public void addNewMessage(Message message) {
        messageRepository.save(message);
    }

    public void deleteMessage(Long messageId) {
        boolean exists = messageRepository.existsById(messageId);

        if (!exists) {
            throw new IllegalStateException("message with id " + messageId + " does not exist");
        }
        messageRepository.deleteById(messageId);
    }
}
