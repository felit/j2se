package com.livedrof.j2se.concurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String args[]) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        
    }
}
