package com.designpattern.demo.Decorator;

public class JobAssistance extends Decorator{

    Member member ;

    public JobAssistance(Member member){
        this.member = member;
    }

    @Override
    public int cost() {
        return 1500 + member.cost();
    }
}
