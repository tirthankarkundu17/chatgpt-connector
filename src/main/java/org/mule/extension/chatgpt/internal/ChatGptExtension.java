package org.mule.extension.chatgpt.internal;

import org.mule.extension.chatgpt.internal.error.ChatGptErrors;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
import org.mule.runtime.extension.api.annotation.error.ErrorTypes;

@Xml(prefix = "ChatGpt")
@Extension(name = "ChatGpt")
@ErrorTypes(ChatGptErrors.class)
@Configurations(ChatGptConfiguration.class)
public class ChatGptExtension {

}
