package com.patern.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

//@Component
public class SchedulerTask {

    private int count=0;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss SSS");
    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
    	System.out.println("现在时间：" + dateFormat.format(new Date()));
        System.out.println("this is scheduler task runing  "+(count++));
    }
    @Scheduled(fixedRate = 6000,fixedDelay = 6000,initialDelay=1000)
    private void process1(){
    	System.out.println("现在时间：" + dateFormat.format(new Date()));
    }

}