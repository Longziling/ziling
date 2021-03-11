package com.ziling.goodlife.pattern.behavior.mediator;

/**
 * 中介者模式
 *
 * 用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 *
 */
public class Mediator1 {

    public static void main(String[] args) {
        SmartDevice bd = new BathDevice();
        SmartDevice cd = new CurtainDevice();
        SmartDevice md = new MusicDevice();
        SmartMediator sm = new ConcreteMediator(bd, cd, md);//把设备引用都保存在调停者中
        cd.operateDevice("open", sm); //开启窗帘
        md.operateDevice("close", sm);//关闭音乐

    }

}

interface SmartDevice {

    //相关设备打开之后 使其进入准备状态
    void readyState(String instruction);
    //操作该设备
    void operateDevice(String instruction, SmartMediator mediator);

}

class BathDevice implements SmartDevice {
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

class CurtainDevice implements SmartDevice {
    @Override
    public void readyState(String instruction) {
        //如果其他设备开启则调用此方法，唤醒窗帘
        System.out.println("窗帘设备准备"+instruction);
    }

    @Override
    public void operateDevice(String instruction, SmartMediator mediator) {
        System.out.println("窗帘已"+instruction);//通过传入指令，打开或关闭窗帘
        mediator.curtain(instruction);//窗帘通过中介者唤醒音乐设备和洗浴设备
    }
}

class MusicDevice implements SmartDevice {
    @Override
    public void readyState(String instruction) {

        System.out.println("音乐设备准备"+instruction);
    }

    @Override
    public void operateDevice(String instruction, SmartMediator mediator) {
        System.out.println("音乐设备已"+instruction);
        mediator.music(instruction);
    }
}

abstract class SmartMediator {
    //保留所有设备的引用是为了当接收指令时可以唤醒其他设备的操作
    SmartDevice bd;
    SmartDevice md;
    SmartDevice cd;

    public SmartMediator(SmartDevice bd, SmartDevice cd, SmartDevice md) {
        super();
        this.bd = bd;
        this.md = md;
        this.cd = cd;
    }

    public abstract void music(String instruction);

    public abstract void curtain(String instruction);

    public abstract void bath(String instruction);
}

class ConcreteMediator extends SmartMediator {

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
