package javaBase.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class OrderThreads {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;

    private int curType = A;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            if (curType != A) {
                condition1.await();
            } else {
                System.out.print("A");
                curType = B;
                //唤醒信号2
                condition2.signal();
            }
        } catch (InterruptedException e) {
        }
        lock.unlock();
    }

    public void printB() {
        lock.lock();
        try {
            if (curType != B) {
                condition2.await();
            } else {
                System.out.print("B");
                curType = C;
                condition3.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    public void printC() {
        lock.lock();
        try {
            if (curType != C) {
                condition3.await();
            } else {
                System.out.print("C");
                curType = A;
                condition1.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}

class ThreadPrint extends Thread {
    public static final int print_count = 5;
    private OrderThreads orderThreads;
    private int type = 0;

    public ThreadPrint(OrderThreads orderThreads, int type) {
        super();
        this.type = type;
        this.orderThreads = orderThreads;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (type == OrderThreads.A) {
                orderThreads.printA();
            } else if (type == OrderThreads.B) {
                orderThreads.printB();
            } else if (type == OrderThreads.C) {
                orderThreads.printC();
            }
        }
    }
}

public class PrintTest {
    public static void main(String[] args) {
        OrderThreads orderThreads = new OrderThreads();
        Thread threadA = new ThreadPrint(orderThreads, OrderThreads.A);
        Thread threadB = new ThreadPrint(orderThreads, OrderThreads.B);
        Thread threadC = new ThreadPrint(orderThreads, OrderThreads.C);

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
