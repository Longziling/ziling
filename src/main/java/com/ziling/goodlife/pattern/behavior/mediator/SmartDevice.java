package com.ziling.goodlife.pattern.behavior.mediator;

public interface SmartDevice {

    //相关设备打开之后 使其进入准备状态
    public void readyState(String instruction);
    //操作该设备
    public void operateDevice(String instruction, SmartMediator mediator);

}
