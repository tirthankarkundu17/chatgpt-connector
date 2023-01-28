package org.mule.extension.chatgpt.api.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChatGptAPIRequest {

    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("prompt")
    @Expose
    private String prompt;
    @SerializedName("temperature")
    @Expose
    private Double temperature;
    @SerializedName("max_tokens")
    @Expose
    private Integer maxTokens;
    @SerializedName("top_p")
    @Expose
    private Integer topP;
    @SerializedName("frequency_penalty")
    @Expose
    private Integer frequencyPenalty;
    @SerializedName("presence_penalty")
    @Expose
    private Integer presencePenalty;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public Integer getTopP() {
        return topP;
    }

    public void setTopP(Integer topP) {
        this.topP = topP;
    }

    public Integer getFrequencyPenalty() {
        return frequencyPenalty;
    }

    public void setFrequencyPenalty(Integer frequencyPenalty) {
        this.frequencyPenalty = frequencyPenalty;
    }

    public Integer getPresencePenalty() {
        return presencePenalty;
    }

    public void setPresencePenalty(Integer presencePenalty) {
        this.presencePenalty = presencePenalty;
    }
}