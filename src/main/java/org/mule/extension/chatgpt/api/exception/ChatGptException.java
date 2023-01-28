package org.mule.extension.chatgpt.api.exception;

public class ChatGptException extends Exception {
    public ChatGptException(String errorMessage) {
        super(errorMessage);
    }
}
