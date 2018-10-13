package javaBase.threads;


import java.util.concurrent.atomic.AtomicBoolean;

class Thread1 extends Thread {
    int sum;
    AtomicBoolean flag;


    public Thread1(AtomicBoolean flag) {
        sum = 0;
        this.flag = flag;
    }

    @Override
    public void run() {
        synchronized (flag) {
            while (sum < 100) {
                if (flag.get()) {
                    System.out.print("thread1 " + sum + " ");
                    flag.set(false);
                    sum += 2;
                }
                try {
                    flag.notifyAll();
                    flag.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

class Thread2 extends Thread {
    int sum;
    AtomicBoolean flag;

    public Thread2(AtomicBoolean flag) {
        sum = 1;
        this.flag = flag;
    }

    @Override
    public void run() {
        synchronized (flag) {
            while (sum < 100) {
                if (!flag.get()) {
                    System.out.print("thread2 " + sum + " ");
                    flag.set(true);
                    sum += 2;
                }
                try {
                    flag.notifyAll();
                    flag.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

public class TwoThread {
    public static void main(String[] args) {
        AtomicBoolean flag = new AtomicBoolean(true);
        Thread thread1 = new Thread1(flag);
        Thread thread2 = new Thread2(flag);
        thread1.start();
        thread2.start();
    }
}
