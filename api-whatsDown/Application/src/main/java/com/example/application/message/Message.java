package com.example.application.message;

import javax.persistence.*;

import com.example.application.person.Person;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table
public class Message {
    @Id
    @SequenceGenerator(name = "mesage_sequence", sequenceName = "message_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "message_sequence")

    private Long id;
    private Integer senderId;
    private String content;

    public Message(Integer senderId, String content) {
        this.senderId = senderId;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSender(Integer senderId) {
        this.senderId = senderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", senderId='" + senderId.toString() + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
