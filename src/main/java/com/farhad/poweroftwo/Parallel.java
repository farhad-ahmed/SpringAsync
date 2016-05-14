package com.farhad.poweroftwo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
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
}
