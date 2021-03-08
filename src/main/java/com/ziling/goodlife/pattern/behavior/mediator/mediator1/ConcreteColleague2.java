package com.ziling.goodlife.pattern.behavior.mediator.mediator1;

public class ConcreteColleague2 extends Colleague {
    @Override
    public void receive() {
        System.out.println("Colleague2 receive message.");
    }

    @Override
    public void send() {
        System.out.println("Colleague2 send message.");
        this.mediator.relay(this);
    }
}
