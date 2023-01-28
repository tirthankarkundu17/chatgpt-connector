package org.mule.extension.chatgpt.api.exception;

public class ChatGptUnauthorizedException extends Exception {
    public ChatGptUnauthorizedException(String errorMessage) {
        super(errorMessage);
    }
}
