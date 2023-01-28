package org.mule.extension.chatgpt.api.service;

import org.mule.extension.chatgpt.api.beans.ChatGptAPIResponse;
import org.mule.extension.chatgpt.api.exception.ChatGptException;
import org.mule.extension.chatgpt.api.exception.ChatGptUnauthorizedException;

public interface ChatGPTService {
    ChatGptAPIResponse correctGrammar(String prompt) throws ChatGptException, ChatGptUnauthorizedException;

    ChatGptAPIResponse tweetClassifier(String tweet) throws ChatGptException, ChatGptUnauthorizedException;

    ChatGptAPIResponse summarize(String text) throws ChatGptException, ChatGptUnauthorizedException;
}
