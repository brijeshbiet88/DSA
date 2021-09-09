package com.leetcode.threading;

public class PrintEvenOddUsingThread {
    static int a = 0 , b = 0;
    public String lock = "";
    public static void main(String[] args) throws InterruptedException {
        int low = 10;
        int high = 20;
        PrintEvenOddUsingThread obj = new PrintEvenOddUsingThread();
        obj.printEvenOdd(low , high);
    }

    private void printEvenOdd(int low, int high) throws InterruptedException{
        a = low;
        b = high;
        Thread even = new Thread(()->{
            try {
                printEvenNumber();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread odd = new Thread(()->{
            try {
                printOddNumber();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        even.start();
        odd.start();
    }

    private void printOddNumber() throws InterruptedException {

        while (a < b){
            synchronized (this){
            while (a %2 == 0){
                wait();
            }
             System.out.println(a++);
                notify();
         }
        }

    }

    private void printEvenNumber() throws InterruptedException{

        while (a < b){
            synchronized (this){
                while (a %2 == 1){
                    wait();
                }
                System.out.println(a++);
                notify();
            }
        }
    }
}
