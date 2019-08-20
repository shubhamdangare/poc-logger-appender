package com.knoldus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.*;
import org.apache.logging.log4j.ThreadContext;

public class MainApplication {

    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/knoldus/Desktop/Work/Assignments-test/poc-logger-appender/log4j.properties");

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<Future<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i <= 2; i++) {
            Demo dobj = new Demo(String.valueOf(i));
            Future<Integer> result = executor.submit(dobj);
            if(executor.submit(dobj).isDone()) {
                resultList.add(result);
                resultList.get(i);
            }

        }


    }
}

