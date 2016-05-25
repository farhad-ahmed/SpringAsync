package com.farhad.poweroftwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import static java.util.concurrent.TimeUnit.MICROSECONDS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Created by Farhad on 5/13/2016.
 */

@Component
public class Caller {

    @Autowired
    private Parallel parallel;
    @Autowired
    private Single single;

    public void work(){
        parallel.method1();
        parallel.method2();
    }

    public void Singlework(){
        single.method1();
        single.method2();
    }

    public void futureWork(){
        Future<String> promptReply = parallel.promptMethod();
        boolean running=true;
        try {
            promptReply.get(150,MILLISECONDS);
            while(running){
                if(promptReply.isDone()){
                    System.out.println("Response: "+promptReply.get());
                    running=false;
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
