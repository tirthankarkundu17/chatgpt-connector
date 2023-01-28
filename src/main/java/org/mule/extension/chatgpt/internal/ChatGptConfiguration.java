package org.mule.extension.chatgpt.internal;

import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

@Operations(ChatGptOperations.class)
public class ChatGptConfiguration {

    @Parameter
    @Summary("Open API Token")
    @Example("fbe2136d-1833-47b3-b6f4-9a9862848a03")
    private String token;

    @Parameter
    @Summary("The max number of tokens to be returned by Chat GPT responses")
    @Example("1000")
    private Integer maxToken;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getMaxToken() {
        return maxToken;
    }

    public void setMaxToken(Integer maxToken) {
        this.maxToken = maxToken;
    }
}
