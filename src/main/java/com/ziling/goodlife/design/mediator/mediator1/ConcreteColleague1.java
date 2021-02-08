package com.ziling.goodlife.design.mediator.mediator1;

public class ConcreteColleague1 extends Colleague {
    @Override
    public void receive() {
        System.out.println("Colleague1 receive message.");
    }

    @Override
    public void send() {
        System.out.println("Colleague1 send message.");
        this.mediator.relay(this);
    }
}
