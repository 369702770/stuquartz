//package com.xyl.quartz;
//
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * 学习StdSchduler
// * @author xunyulong【xunyulong@goldwind.com.cn】
// * @date 2018/12/19 上午11:39
// */
//public class SchdulerTest {
//    public static void main(String[] args) throws SchedulerException {
////        Date date = new Date();
////        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        //创建一个JobDetail实例，将该实例与HelloJob Class绑定
////        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
////                .withIdentity("myjob", "group1")
////                .build();
////        //每秒钟出发一次任务
////        CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger()
////                .withIdentity("myTrigger", "group1")
////                .startNow()
////                //无限次执行
////                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ? *"))
////                //.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).withRepeatCount(1))
////                .build();
////        SchedulerFactory sfact = new StdSchedulerFactory();
////        Scheduler scheduler = sfact.getScheduler();
////        scheduler.start();
////        System.out.println("scheduled time is :"+sf.format(scheduler.scheduleJob(jobDetail, trigger)));
//        SchedulerFactory sfact = new StdSchedulerFactory();
//        Scheduler scheduler = sfact.getScheduler();
//        //System.out.println(sfact.getAllSchedulers());
//        JobKey jobKey=new JobKey("myjob","group1");
//        scheduler.deleteJob(jobKey);
//        scheduler.shutdown();
//    }
//}
