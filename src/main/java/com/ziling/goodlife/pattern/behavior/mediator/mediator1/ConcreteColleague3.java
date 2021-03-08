package com.ziling.goodlife.pattern.behavior.mediator.mediator1;

public class ConcreteColleague3 extends Colleague {
    @Override
    public void receive() {
        System.out.println("Colleague3 receive message.");
    }

    @Override
    public void send() {
        System.out.println("Colleague3 send message.");
        this.mediator.relay(this);
    }
}
