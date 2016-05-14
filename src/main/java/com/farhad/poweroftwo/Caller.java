package com.farhad.poweroftwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
