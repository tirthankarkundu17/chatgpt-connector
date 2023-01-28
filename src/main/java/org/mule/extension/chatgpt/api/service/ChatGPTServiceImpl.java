package org.mule.extension.chatgpt.api.service;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.mule.extension.chatgpt.api.beans.ChatGptAPIRequest;
import org.mule.extension.chatgpt.api.beans.ChatGptAPIResponse;
import org.mule.extension.chatgpt.api.exception.ChatGptException;
import org.mule.extension.chatgpt.api.exception.ChatGptUnauthorizedException;
import org.mule.runtime.http.api.HttpConstants;

public class ChatGPTServiceImpl implements ChatGPTService {

    private final int maxToken;
    private final String authToken;
    private final String chatGptUrl = "https://api.openai.com/v1/completions";
    private final Gson gson = new Gson();

    public ChatGPTServiceImpl(int maxToken, String authToken) {
        this.maxToken = maxToken;
        this.authToken = authToken;
    }

    private ChatGptAPIResponse converseWithChatGPT(String input) throws ChatGptException, ChatGptUnauthorizedException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {

            ChatGptAPIRequest apiRequest = new ChatGptAPIRequest();
            apiRequest.setModel("text-davinci-003");
            apiRequest.setPrompt(input);
            apiRequest.setTemperature(0.7);
            apiRequest.setMaxTokens(this.maxToken);
            apiRequest.setTopP(1);
            apiRequest.setFrequencyPenalty(0);
            apiRequest.setPresencePenalty(0);

            HttpPost request = new HttpPost(this.chatGptUrl);
            request.addHeader("Authorization", "Bearer " + this.authToken);
            StringEntity entity = new StringEntity(gson.toJson(apiRequest));
            entity.setContentType("application/json");
            request.setEntity(entity);
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpConstants.HttpStatus.UNAUTHORIZED.getStatusCode()) {
                throw new ChatGptUnauthorizedException("Unauthorized");
            }
            HttpEntity respEntity = response.getEntity();
            String content = EntityUtils.toString(respEntity);
            return gson.fromJson(content, ChatGptAPIResponse.class);
        } catch (ChatGptUnauthorizedException e) {
            throw e;
        } catch (Exception e) {
            throw new ChatGptException(e.getMessage());
        }
    }

    @Override
    public ChatGptAPIResponse correctGrammar(String prompt) throws ChatGptException, ChatGptUnauthorizedException {
        return this.converseWithChatGPT("Correct this to standard English:" + prompt);
    }

    @Override
    public ChatGptAPIResponse tweetClassifier(String tweet) throws ChatGptException, ChatGptUnauthorizedException {
        return this.converseWithChatGPT("Decide whether a Tweet's sentiment is positive, neutral, or negative.:" + tweet);
    }

    @Override
    public ChatGptAPIResponse summarize(String text) throws ChatGptException, ChatGptUnauthorizedException {
        return this.converseWithChatGPT(text + "tl;dr:");
    }
}
