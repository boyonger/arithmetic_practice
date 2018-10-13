package javaBase.threads.threadTools;

import java.util.concurrent.*;

/*
four threadTools in Executor:
newFixedThreadTools:固定数目的线程池
newCachedThreadPool:可缓存线程，优先使用违背使用的线程，若无则新建
newSingleThreadPool:单线程
newSingleThreadExecutor：newScheduledThreadPool：定时任务执行的线程池

ExecutorService:Executor的实现类

ThreadPoolExecutor:自定义线程池


 */
public class ExecutorTools {
    public static void main(String[] args){
        BlockingQueue<Runnable> blockingQueue=new ArrayBlockingQueue<Runnable>(20);
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(3,5,50,TimeUnit.SECONDS,blockingQueue);

    }
}
