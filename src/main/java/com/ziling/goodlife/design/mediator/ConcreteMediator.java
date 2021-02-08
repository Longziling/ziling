package com.ziling.goodlife.design.mediator;

public class ConcreteMediator extends SmartMediator {

    public ConcreteMediator(SmartDevice bd, SmartDevice cd, SmartDevice md) {
        super(bd, cd, md);
    }


    @Override
    public void music(String instruction) {
        cd.readyState(instruction);//调用窗帘的准备方法
        bd.readyState(instruction);//调用洗浴设备的准备方法
    }

    @Override
    public void curtain(String instruction) {
        md.readyState(instruction);
        bd.readyState(instruction);
    }

    @Override
    public void bath(String instruction) {
        cd.readyState(instruction);
        md.readyState(instruction);
    }
}
