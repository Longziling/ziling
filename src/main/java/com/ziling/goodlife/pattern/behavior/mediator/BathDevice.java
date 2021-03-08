package com.ziling.goodlife.pattern.behavior.mediator;

public class BathDevice implements SmartDevice {
    @Override
    public void readyState(String instruction) {

        System.out.println("洗浴设备正在准备"+instruction);
    }

    @Override
    public void operateDevice(String instruction, SmartMediator mediator) {
        System.out.println("洗浴设备"+instruction);
        mediator.bath(instruction);

    }
}
