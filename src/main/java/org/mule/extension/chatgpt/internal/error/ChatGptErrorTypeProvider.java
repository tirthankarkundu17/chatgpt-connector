package org.mule.extension.chatgpt.internal.error;

import org.mule.runtime.extension.api.annotation.error.ErrorTypeProvider;
import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

import java.util.HashSet;
import java.util.Set;

import static org.mule.extension.chatgpt.internal.error.ChatGptErrors.*;

public class ChatGptErrorTypeProvider implements ErrorTypeProvider {
    @Override
    public Set<ErrorTypeDefinition> getErrorTypes() {
        Set<ErrorTypeDefinition> errors = new HashSet<>();
        errors.add(NULL_VALUE);
        errors.add(INVALID_TOKEN);
        errors.add(PROCESSING_ERROR);
        errors.add(ANY);
        return errors;
    }
}
