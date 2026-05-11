package com.CodeForge.aI.CodeForgeAI.cli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class CodeForgeCli implements CommandLineRunner {
    private final CommandRouter commandRouter;

    CodeForgeCli(CommandRouter commandRouter) {
        this.commandRouter = commandRouter;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(commandRouter.route(args));
    }
}
