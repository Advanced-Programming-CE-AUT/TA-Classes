package com.raceCondition;

public class RaceConditionExample implements Runnable {
    private final Counter counter;

    public RaceConditionExample(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("counter value: " + counter.getCounter() + " thread name: " + Thread.currentThread().getName());

//        addition
        counter.add();
        System.out.println("after addition the current counter value is: " + counter.getCounter() + " in thread: " + Thread.currentThread().getName());
        
//        subtraction
        counter.subtract();
        System.out.println("after subtraction the current counter value is: " + counter.getCounter() + " in thread: " + Thread.currentThread().getName());
    }
}
