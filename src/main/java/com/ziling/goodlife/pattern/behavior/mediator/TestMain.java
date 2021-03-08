package com.ziling.goodlife.pattern.behavior.mediator;

public class TestMain {

    public static void main(String[] args) {
        SmartDevice bd = new BathDevice();
        SmartDevice cd = new CurtainDevice();
        SmartDevice md = new MusicDevice();
        SmartMediator sm = new ConcreteMediator(bd, cd, md);//把设备引用都保存在调停者中
        cd.operateDevice("open", sm); //开启窗帘
        md.operateDevice("close", sm);//关闭音乐

    }
}
