package com.designpattern.demo.Decorator;

public class Assignment extends Decorator{

    Member member ;

    public Assignment(Member member){
        this.member = member;
    }

    @Override
    public int cost() {
        return 500 + member.cost();
    }
}
