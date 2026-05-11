package com.CodeForge.aI.CodeForgeAI.cli;

import com.CodeForge.aI.CodeForgeAI.service.AIService;
import org.springframework.stereotype.Component;

@Component
public class CommandRouter {

    private final AIService aiService;

    CommandRouter(AIService aiService) {
        this.aiService = aiService;
    }

    public String route(String[] args) {

        if (args.length == 0) {
            return help();
        }

        String command = args[0];

        return switch (command.toLowerCase()) {

            case "explain" -> handleExplain(args);

            case "read" -> handleRead(args);

            case "help" -> help();

            default -> aiService.askAgent(String.join(" ", args));
        };
    }

    private String handleExplain(String[] args) {

        if (args.length < 2) {
            return "Usage: codeforge explain <file-path>";
        }

        String path = args[1];

        return aiService.askAgent(
                "Explain this file: " + path
        );
    }

    private String handleRead(String[] args) {

        if (args.length < 2) {
            return "Usage: codeforge read <file-path>";
        }

        return aiService.askAgent(
                "Read and analyze this file: " + args[1]
        );
    }

    private String help() {

        return """
                CodeForge AI CLI

                Commands:
                  explain <file path>   → explain code file
                  read <file path>      → read file content
                  help             → show this help

                Examples:
                  codeforge explain pom.xml
                  codeforge read D:/project/UserService.java
                """;
    }
}