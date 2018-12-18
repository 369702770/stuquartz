package com.xyl.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.CronTrigger;

import java.util.Date;

/**
 * 基于日历的作业调度
 * @author xunyulong【xunyulong@goldwind.com.cn】
 * @date 2018/12/18 下午8:08
 */
public class CronTriggerTest {

    public static void main(String[] args) throws SchedulerException {
        Date date = new Date();
        //创建一个JobDetail实例，将该实例与HelloJob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myjob", "group1")
                .build();
        //每秒钟出发一次任务
        CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                //无限次执行
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                .build();
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
