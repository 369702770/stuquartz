package com.xyl.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author xunyulong【xunyulong@goldwind.com.cn】
 * @date 2018/12/19 下午1:47
 */
@RestController
public class JobController {

    @GetMapping("/start")
    public void start() throws SchedulerException {
        Date date = new Date();
        //创建一个JobDetail实例，将该实例与HelloJob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myjob", "group1")
                .build();
        System.out.println(jobDetail.getKey().getName());
        System.out.println(jobDetail.getKey().getGroup());
        System.out.println(jobDetail.getJobClass().getName());
        //距离当前时间4秒钟执行且仅执行一次 然后每隔2秒执行一次
        SimpleTrigger trigger1 = (SimpleTrigger) TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                //两秒钟执行一次 无限次执行
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY))
                .build();
        StdSchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger1);
        scheduler.start();
    }

    @GetMapping("/shutdown")
    public void shutdown() throws SchedulerException {
        StdSchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        //scheduler.shutdown(true);
        JobKey jobKey=new JobKey("myjob", "group1");
        scheduler.deleteJob(jobKey);
    }

}
