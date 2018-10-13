package javaBase.threads;

//第一种新建多线程方法
class MyThread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

//实现接口
class MyRunnable implements Runnable{
    private int i=0;
    @Override
    public void run(){
        for (i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Thread myThread = new MyThread();
        Thread myThread1 = new MyThread();
        myThread.start();
        myThread1.start();

        Runnable myRunnable=new MyRunnable();
        Thread runnableThread=new Thread(myRunnable);
        Thread runnableThread1=new Thread(myRunnable);
        Thread runnable3=new Thread(new Runnable() {
            @Override
            public void run() {
                //write some;
            }
        });
        runnableThread.start();
        runnableThread1.start();
    }
}