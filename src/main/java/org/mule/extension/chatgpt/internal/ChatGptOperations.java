package org.mule.extension.chatgpt.internal;

import org.mule.extension.chatgpt.api.beans.ChatGptAPIResponse;
import org.mule.extension.chatgpt.api.beans.Choice;
import org.mule.extension.chatgpt.api.exception.ChatGptException;
import org.mule.extension.chatgpt.api.exception.ChatGptUnauthorizedException;
import org.mule.extension.chatgpt.api.service.ChatGPTService;
import org.mule.extension.chatgpt.api.service.ChatGPTServiceImpl;
import org.mule.extension.chatgpt.internal.error.ChatGptErrorTypeProvider;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.exception.ModuleException;

import java.util.List;
import java.util.stream.Collectors;

import static org.mule.extension.chatgpt.internal.error.ChatGptErrors.*;

public class ChatGptOperations {

    @MediaType(value = MediaType.ANY, strict = false)
    @DisplayName("Correct Grammar")
    @Throws({ChatGptErrorTypeProvider.class})
    public String correctGrammar(@Config ChatGptConfiguration configuration, String text) {
        String response = "";
        ChatGPTService chatGPTService = new ChatGPTServiceImpl(configuration.getMaxToken(), configuration.getToken());
        ChatGptAPIResponse chatGptAPIResponse = null;
        try {
            chatGptAPIResponse = chatGPTService.correctGrammar(text);
        } catch (ChatGptException e) {
            throw new ModuleException(PROCESSING_ERROR, e);
        } catch (ChatGptUnauthorizedException e) {
            throw new ModuleException(INVALID_TOKEN, new Exception("Invalid Token set for the connector"));
        }
        List<Choice> choices = chatGptAPIResponse.getChoices();
        if (choices.size() < 0)
            throw new ModuleException(NULL_VALUE, new Exception("No response found for this"));

        response = choices.stream().map(Choice::getText).collect(Collectors.joining(" ")).trim();

        return response;
    }

    @MediaType(value = MediaType.ANY, strict = false)
    @DisplayName("Summarize Text")
    @Throws({ChatGptErrorTypeProvider.class})
    public String summarizeText(@Config ChatGptConfiguration configuration, String text) {
        String response = "";
        ChatGPTService chatGPTService = new ChatGPTServiceImpl(configuration.getMaxToken(), configuration.getToken());
        ChatGptAPIResponse chatGptAPIResponse = null;
        try {
            chatGptAPIResponse = chatGPTService.summarize(text);
        } catch (ChatGptException e) {
            throw new ModuleException(PROCESSING_ERROR, e);
        } catch (ChatGptUnauthorizedException e) {
            throw new ModuleException(INVALID_TOKEN, new Exception("Invalid Token set for the connector"));
        }
        List<Choice> choices = chatGptAPIResponse.getChoices();
        if (choices.size() < 0)
            throw new ModuleException(NULL_VALUE, new Exception("No response found for this"));

        response = choices.stream().map(Choice::getText).collect(Collectors.joining(" ")).trim();

        return response;
    }

    @MediaType(value = MediaType.ANY, strict = false)
    @DisplayName("Classify Tweet")
    @Throws({ChatGptErrorTypeProvider.class})
    public String classifyTweet(@Config ChatGptConfiguration configuration, String tweet) {
        String response = "";
        ChatGPTService chatGPTService = new ChatGPTServiceImpl(configuration.getMaxToken(), configuration.getToken());
        ChatGptAPIResponse chatGptAPIResponse = null;
        try {
            chatGptAPIResponse = chatGPTService.tweetClassifier(tweet);
        } catch (ChatGptException e) {
            throw new ModuleException(PROCESSING_ERROR, e);
        } catch (ChatGptUnauthorizedException e) {
            throw new ModuleException(INVALID_TOKEN, new Exception("Invalid Token set for the connector"));
        }
        List<Choice> choices = chatGptAPIResponse.getChoices();
        if (choices.size() < 0)
            throw new ModuleException(NULL_VALUE, new Exception("No response found for this"));

        response = choices.stream().map(Choice::getText).collect(Collectors.joining(" ")).trim();

        return response;
    }
}
