package com.ziling.goodlife.pattern.behavior.command;

public class Main {
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
