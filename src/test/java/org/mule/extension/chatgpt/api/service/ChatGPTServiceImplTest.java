package org.mule.extension.chatgpt.api.service;

import org.junit.Assert;
import org.junit.Test;
import org.mule.extension.chatgpt.api.beans.ChatGptAPIResponse;
import org.mule.extension.chatgpt.api.beans.Choice;
import org.mule.extension.chatgpt.api.exception.ChatGptException;
import org.mule.extension.chatgpt.api.exception.ChatGptUnauthorizedException;

import java.util.stream.Collectors;

public class ChatGPTServiceImplTest {

    private final String authToken = "add_token_here";
    private final ChatGPTService chatGPTService = new ChatGPTServiceImpl(60, authToken);
    private final ChatGPTService badChatGPTService = new ChatGPTServiceImpl(60, "abc");

    @Test
    public void testCorrectGrammarSuccess() throws ChatGptException, ChatGptUnauthorizedException {
        ChatGptAPIResponse response = chatGPTService.correctGrammar("I football love");
        String text = response.getChoices().stream().map(Choice::getText).collect(Collectors.joining(" ")).trim();
        Assert.assertEquals(text, "I love football.");
    }

    @Test(expected = ChatGptUnauthorizedException.class)
    public void testUnauthorized() throws ChatGptUnauthorizedException, ChatGptException {
        badChatGPTService.correctGrammar("I football love");
    }

    @Test
    public void testTweetClassifier() throws ChatGptUnauthorizedException, ChatGptException {
        ChatGptAPIResponse response = chatGPTService.tweetClassifier("I love ChatGpt");
        String text = response.getChoices().stream().map(Choice::getText).collect(Collectors.joining(" ")).trim();
        Assert.assertTrue(text.contains("Positive"));
    }
}