package com.ziling.goodlife.design.mediator.mediator1;

public abstract class Colleague {

    protected Mediator mediator;

    public abstract void receive();

    public abstract void send();

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

}
