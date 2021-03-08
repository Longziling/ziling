package com.ziling.goodlife.pattern.behavior.command;

import java.util.ArrayList;
import java.util.List;

public class RemoteControl {

    private Command[] onCommands;

    private Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    public void setCommand(Integer slot, Command onCommand, Command offCommand) {
        this.onCommands[slot] = onCommand;
        this.offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(Integer slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(Integer slot) {
        offCommands[slot].execute();
    }


    private List<Command> commandList = new ArrayList<>();

    public void setCommand(Command command) {
        commandList.add(command);
    }

    public void execute() {
        for (Command command : commandList) {
            command.execute();
        }
    }



}
