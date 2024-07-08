package com.northcoders.surfeillance.model.dto;

public class MessageDto {

    private String Message;

    public MessageDto(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
