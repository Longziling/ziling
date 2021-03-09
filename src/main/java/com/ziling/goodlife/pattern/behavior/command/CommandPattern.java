package com.ziling.goodlife.pattern.behavior.command;

import java.util.ArrayList;
import java.util.List;

public class CommandPattern {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light light = new Light("Living Room");

        Light washLight = new Light("Wash Room");

        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        LightOnCommand washLightOnCommand = new LightOnCommand(washLight);
        LightOffCommand washLightOffCommand = new LightOffCommand(washLight);

        remoteControl.setCommand(0, lightOnCommand, lightOffCommand);

        remoteControl.setCommand(1, washLightOnCommand, washLightOffCommand);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);

        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
    }

}

interface Command {
    void execute();
}

class Light {

    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(this.name + " Light is on");
    }

    public void off() {
        System.out.println(this.name + " Light is off");
    }
}

class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("no command");
    }
}

class RemoteControl {

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


