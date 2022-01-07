package com.designpattern.demo.Observer;

public interface Subject {

    public void register(Observer obj);
    public void unregister(Observer obj);

    public void notifyObservers();

    //method to get updates from subject
    public Object getUpdate(Observer obj);

}
