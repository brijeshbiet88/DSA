package com.designpattern.demo.Decorator;

public class DoubtSession extends Decorator{

    Member member;

    public DoubtSession(Member member){
        this.member = member;
    }

    @Override
    public int cost() {
        return 1000 + member.cost();
    }
}
