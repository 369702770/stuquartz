//package com.xyl.quartz;
//
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @author xunyulong【xunyulong@goldwind.com.cn】
// * @date 2018/11/5 下午3:06
// */
//public class HelloScheduler {
//    public static void main(String[] args) throws SchedulerException, InterruptedException {
//        Date date = new Date();
//        //创建一个JobDetail实例，将该实例与HelloJob Class绑定
//        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
//                .withIdentity("myjob", "group1")
//                .usingJobData("message", "hello myjob1")
//                .usingJobData("FloatJobValue", 3.14F)
//                .build();
//        System.out.println(jobDetail.getKey().getName());
//        System.out.println(jobDetail.getKey().getGroup());
//        System.out.println(jobDetail.getJobClass().getName());
//        date.setTime(date.getTime() + 3000);
//
//
////        //创建一个Trigger实例，定义该job立即执行，并且每隔两秒钟重复执行一次
////        SimpleTrigger trigger =(SimpleTrigger) TriggerBuilder.newTrigger()
////                .withIdentity("myTrigger", "group1")
////                .usingJobData("message", "hello myTrigger1")
////                .usingJobData("DoubleJobValue", 2.0D)
////                .startAt(date)
////                .endAt(endDate)
////                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
////        //创建Scheduler实例
////        SchedulerFactory sfact = new StdSchedulerFactory();
////        Scheduler scheduler = sfact.getScheduler();
////        scheduler.start();
////        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        System.out.println("Current Exec time is：" + sf.format(date));
////        scheduler.scheduleJob(jobDetail, trigger);
//        date.setTime(date.getTime() + 2000);
//        //距离当前时间4秒钟执行且仅执行一次 然后每隔2秒执行一次
//        SimpleTrigger trigger1 = (SimpleTrigger) TriggerBuilder.newTrigger()
//                .withIdentity("myTrigger", "group1")
//                .startNow()
//                //两秒钟执行一次 无限次执行
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY))
//                .build();
//        StdSchedulerFactory sfact = new StdSchedulerFactory();
//        Scheduler scheduler = sfact.getScheduler();
//        scheduler.scheduleJob(jobDetail, trigger1);
//        scheduler.start();
//        System.out.println(sfact.getAllSchedulers());
////        Thread.sleep(10000);
////        scheduler.shutdown(true);
////        System.out.println(scheduler.isShutdown());
////        Thread.sleep(3000);
//        //scheduler.shutdown();
//
//
//    }
//}
