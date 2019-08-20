package com.knoldus;

import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import java.util.concurrent.Callable;

public class Demo implements Callable<Integer> {

    private String topic = null;

    Demo(String topic) {

        this.topic = topic;
    }

    @Override
    public Integer call() throws Exception {
        Logger LOGGER = null;
        FileAppender appender = null;
        appender = new FileAppender();
        String path = String.format("/home/knoldus/Desktop/Work/Assignments-test/poc-logger-appender/%s.log", topic);
        appender.setFile(path);
        appender.setLayout(new PatternLayout("%d [%t] %-5p %c - %m%n"));
        appender.activateOptions();
        LOGGER = LogManager.getLogger(Demo.class);
        LOGGER.setAdditivity(false);
        LOGGER.addAppender(appender);
        Thread.currentThread().setName(topic);
        LOGGER.info(topic);
        for (int i = 0; i < Integer.parseInt(topic); i++) {
            LOGGER.info(i);
        }
        LOGGER.removeAllAppenders();
        return 1;

    }
}

