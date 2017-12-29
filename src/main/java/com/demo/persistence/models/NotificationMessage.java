package com.demo.persistence.models;

import com.demo.persistence.enums.NotificationMessageType;

public class NotificationMessage {
    private NotificationMessageType type;
    private String text;

    public NotificationMessage(NotificationMessageType type, String text) {
        this.type = type;
        this.text = text;
    }

    public NotificationMessageType getType() {
        return type;
    }

    public void setType(NotificationMessageType type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
