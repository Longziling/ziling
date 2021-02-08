package com.ziling.goodlife.design.mediator.mediator1;

public abstract class Mediator {

    public abstract void register(Colleague colleague);

    public abstract void relay(Colleague colleague);
}
