package com.ziling.goodlife.design.mediator.mediator1;

public class TestMain {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();

        Colleague colleague1 = new ConcreteColleague1();
        Colleague colleague2 = new ConcreteColleague2();

        mediator.register(colleague1);
        mediator.register(colleague2);

        colleague1.send();
        colleague2.send();

    }
}
