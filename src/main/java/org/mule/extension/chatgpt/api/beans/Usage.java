
package org.mule.extension.chatgpt.api.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usage {

    @SerializedName("prompt_tokens")
    @Expose
    private Integer promptTokens;
    @SerializedName("completion_tokens")
    @Expose
    private Integer completionTokens;
    @SerializedName("total_tokens")
    @Expose
    private Integer totalTokens;

    public Integer getPromptTokens() {
        return promptTokens;
    }

    public void setPromptTokens(Integer promptTokens) {
        this.promptTokens = promptTokens;
    }

    public Integer getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(Integer completionTokens) {
        this.completionTokens = completionTokens;
    }

    public Integer getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(Integer totalTokens) {
        this.totalTokens = totalTokens;
    }
}
