package com.CodeForge.aI.CodeForgeAI.service;

import com.CodeForge.aI.CodeForgeAI.tools.FileTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIService {
    private final ChatClient.Builder chatClientBuilder;
    private final FileTools fileTools;

    AIService(ChatClient.Builder chatClientBuilder, FileTools fileTools) {
        this.chatClientBuilder = chatClientBuilder;
        this.fileTools = fileTools;
    }

    public String askAgent(String message) {
        ChatClient chatClient = chatClientBuilder.build();

        return chatClient.prompt()
                .system("""
                    You are an expert software engineer and AI coding assistant.
                    
                    You can:
                        - Read and analyze codebases
                        - Explain code clearly
                        - Generate production-quality code
                        - Refactor code
                        - Debug errors
                        - Follow existing project architecture
                        - Work with multiple programming languages and frameworks
                    
                    Rules:
                        - Write clean and maintainable code
                        - Prefer simple solutions
                        - Explain reasoning clearly
                        - Generate compilable and correct code
                        - Follow best practices
                        - Do not invent libraries or APIs
                    """).user(message)
                .tools(fileTools)
                .call()
                .content();
    }
}
