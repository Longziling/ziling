package com.ziling.goodlife.design.mediator.mediator1;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator extends Mediator {

    private List<Colleague> colleagueList;

    public ConcreteMediator() {
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
