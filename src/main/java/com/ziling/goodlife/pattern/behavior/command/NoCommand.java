package com.ziling.goodlife.pattern.behavior.command;

public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("no command");
    }
}
