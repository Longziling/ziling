package com.ziling.goodlife.pattern.behavior.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式
 *
 * 用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 *
 */
public class Mediator {

    public static void main(String[] args) {
        MediatorPattern mediator = new ConcreteMediator1();

        Colleague colleague1 = new ConcreteColleague1();
        Colleague colleague2 = new ConcreteColleague2();
        Colleague colleague3 = new ConcreteColleague3();
        mediator.register(colleague1);
        mediator.register(colleague2);
        mediator.register(colleague3);

        colleague1.send();
        colleague2.send();

    }

}

abstract class MediatorPattern {

    abstract void register(Colleague colleague);

    abstract void relay(Colleague colleague);
}

abstract class Colleague {

    protected MediatorPattern mediator;

    public abstract void receive();

    public abstract void send();

    public void setMediator(MediatorPattern mediator) {
        this.mediator = mediator;
    }

}

class ConcreteColleague1 extends Colleague {
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

class ConcreteColleague2 extends Colleague {
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

class ConcreteColleague3 extends Colleague {
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

class ConcreteMediator1 extends MediatorPattern {

    private List<Colleague> colleagueList;

    public ConcreteMediator1() {
        colleagueList = new ArrayList<>();
    }

    @Override
    public void register(Colleague colleague) {
        if (!colleagueList.contains(colleague)) {
            colleague.setMediator(this);
            this.colleagueList.add(colleague);
        }
    }

    @Override
    public void relay(Colleague colleague) {
        colleagueList.forEach(c -> {
            if (!c.equals(colleague)) {
                c.receive();
            }
        });
    }
}





