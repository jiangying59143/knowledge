package common.thread;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCreateTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread = new Thread("simple"){
            @Override
            public void run() {
                System.out.println("thread:" + this.getName());
            }
        };
        thread.start();

        Thread thread1 = new Thread(()->System.out.println("thread:" + Thread.currentThread().getName()),"runnable");
        thread1.start();

        FutureTask<String> ft = new FutureTask<String>(()-> "future callable" + Thread.currentThread().getName());

        new Thread(ft,"有返回值的线程").start();
        System.out.println("子线程的返回值:"+ft.get());

    }
}
