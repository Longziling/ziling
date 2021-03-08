package com.ziling.goodlife.pattern.behavior.mediator.mediator1;

public abstract class Mediator {

    public abstract void register(Colleague colleague);

    public abstract void relay(Colleague colleague);
}
