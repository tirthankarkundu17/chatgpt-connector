package org.mule.extension.chatgpt.internal.error;

import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

public enum ChatGptErrors implements ErrorTypeDefinition<ChatGptErrors> {
    NULL_VALUE,
    INVALID_TOKEN,
    PROCESSING_ERROR,
    ANY
}
