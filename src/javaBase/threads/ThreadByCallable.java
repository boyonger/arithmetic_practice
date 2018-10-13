package javaBase.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadByCallable {
    public static void main(String[] args){
        Callable<Integer> myCallable=new MyCallable();
        FutureTask<Integer> ft=new FutureTask<Integer>(myCallable);
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            if (i==30){
                Thread thread=new Thread(ft);
                thread.start();
            }
        }
    }
}


class MyCallable implements Callable<Integer>{

    public int i=0;

    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            sum+=i;
        }
        return sum;
    }
}