package com.aiagent.plantaiagent.component;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatCompletion;
import com.openai.models.ChatCompletionCreateParams;
import com.openai.models.ChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OpenAiRunner implements CommandLineRunner {
    @Value("${spring.ai.openai.api-key}")
    private String apiKey;

    @Value("${spring.ai.openai.organization-id}")
    private String orgId;

    @Value("${spring.ai.openai.project-id}")
    private String projectId;

    @Override
    public void run(String... args) throws Exception {
        OpenAIClient client = OpenAIOkHttpClient.builder()
            .apiKey(apiKey)
            .organization(orgId)
            .project(projectId)
            .build();


        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
            .addUserMessage("Say this is a test")
            .model(ChatModel.O3_MINI)
            .build();

        ChatCompletion chatCompletion = client.chat().completions().create(params);
        System.out.println(chatCompletion.choices().get(0).message().content());
    }
    }

