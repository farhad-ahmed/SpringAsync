package com.farhad.poweroftwo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class Parallel {
    @Async
    public void method1(){
        try {
            long init= System.currentTimeMillis();
            Thread.sleep(3000);
            System.out.print("Parallel method1 done");
            long end = System.currentTimeMillis();
            System.out.println(" : "+(end-init)+" ms " +Thread.currentThread().getName());
            System.out.println("Method 1: " +new Timestamp(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Async
    public void method2(){
        try {
            long init= System.currentTimeMillis();
            Thread.sleep(1000);
            System.out.print("method2 done");
            long end = System.currentTimeMillis();
            System.out.println(" : "+(end-init)+" ms "+Thread.currentThread().getName());
            System.out.println("Method 2: " +new Timestamp(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Async
    public Future<String> promptMethod(){
        String returned = "Hi Caller: This is Prompt Method";
        try {
            long init= System.currentTimeMillis();

            Thread.sleep(100);
            System.out.println("I am Mr. Prompt and I am not going to be late");
            long end = System.currentTimeMillis();
            System.out.println(" : "+(end-init)+" ms "+Thread.currentThread().getName());
            System.out.println("Prompt Method: " +new Timestamp(System.currentTimeMillis()));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<String>(returned);

    }
}
