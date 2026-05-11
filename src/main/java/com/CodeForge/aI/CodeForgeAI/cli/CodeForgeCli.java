package com.CodeForge.aI.CodeForgeAI.cli;

import com.CodeForge.aI.CodeForgeAI.service.AIService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class CodeForgeCli implements CommandLineRunner {
    private final AIService aiService;

    CodeForgeCli(AIService aiService) {
        this.aiService = aiService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (args.length == 0) {
            System.out.println("Usage: codeforge \"your prompt\"");
            return;
        }

        String message = String.join(" ", args);

        System.out.println("\nCodeForge AI running...\n");

        String response = aiService.askAgent(message);

        System.out.println("\n===== Response =====\n");
        System.out.println(response);
    }
}
