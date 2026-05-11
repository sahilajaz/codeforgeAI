package com.CodeForge.aI.CodeForgeAI.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.logging.Logger;

@Component
public class FileTools {

    private static final Logger log = Logger.getLogger(FileTools.class.getName());

    @Tool(description = "Read file content")
    public String readFile(String path) {
        try {
            log.info("Reading file from path: " + path);

            String content = Files.readString(Path.of(path));

            log.info("Successfully read file: " + path);
            
            return content;
        } catch (Exception e) {
            return "Error reading file: " + e.getMessage();
        }
    }

    @Tool(description = "Write generated code into a file. Creates folders if needed.")
    public String writeFile(String path , String content) {
        try {
            Path filePath = Path.of(path);

            if (filePath.getParent() != null) {
                Files.createDirectories(filePath.getParent());
            }

            Files.writeString(
                    filePath,
                    content,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );

            return "File written successfully: " + path;
        } catch (Exception e) {
            return "Error writing file: " + e.getMessage();
        }
    }
}
