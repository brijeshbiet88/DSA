package com.designpattern.demo.Decorator;

public class Client {

    public static void main(String[] args) {
        Member lifeTimeSubs = new LifetimeSubscription();
        Member assignment = new Assignment(lifeTimeSubs);
        Member jobAssitance = new JobAssistance(assignment);
        System.out.println("Cost incurred on Plan1 i.e Lifetime + Assignment + Job Assistance = "+jobAssitance.cost());
        Member doubtSession = new DoubtSession(jobAssitance);
        System.out.println("Cost incurred on Plan2 i.e Lifetime + Assignment + Job Assistance + Doubt Session = "+doubtSession.cost());
    }
}
