package com.CodeForge.aI.CodeForgeAI.cli;

import com.CodeForge.aI.CodeForgeAI.service.AIService;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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

            case "generate" -> generateCode(args);

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

    private String generateCode(String[] args) {
        if (args.length < 3) {
            return "Usage: codeforge generate [-rw] <file-path> <language> <task>";
        }

        boolean overWrite = false;
        int index = 1;

        if ("-rw".equals(args[index])) {
            overWrite = true;
            index++;
        }

        String filePath = args[index++];

        if (index >= args.length) {
            return "Missing language";
        }

        String language = args[index++];

        String task = String.join(" ",
                Arrays.copyOfRange(args, index, args.length)
        );

        return aiService.askAgent(
                """
                You are a code generation agent.
        
                Language: %s
                Task: %s
                FilePath: %s
                Overwrite: %s
                """.formatted(language, task, filePath, overWrite)
        );
    }

    private String help() {

        return """
                CodeForge AI CLI

                Commands:
                  explain <file path>   → explain code file
                  read <file path>      → read file content
                  help             → show this help
                  generate <file path> <language> <task>  → generate code
                  generate -rw <file path> <language> <task>  → generate code
                
                Examples:
                  codeforge explain pom.xml
                  codeforge read D:/project/UserService.java
                """;
    }
}