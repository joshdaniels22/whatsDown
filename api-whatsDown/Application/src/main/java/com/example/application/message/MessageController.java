package com.example.application.message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/message")
public class MessageController {

    private final MessageService messageService;

    @Autowired // to enable dependency injection
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getMesages() {
        return messageService.getMessages();
    }

    @PostMapping  
    public void registerNewMessage(@RequestBody Message message) {
        messageService.addNewMessage(message);
    }

    @DeleteMapping(path = "{messageId}")
    public void deleteMessage(@PathVariable("messageId") Long messageId){
        messageService.deleteMessage(messageId);
    }
}
