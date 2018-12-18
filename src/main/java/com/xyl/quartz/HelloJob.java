package com.xyl.quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xunyulong【xunyulong@goldwind.com.cn】
 * @date 2018/11/5 下午2:10
 */

public class HelloJob implements Job {
    private String message;
    private Float floatJobValue;
    private Double doubleJobValue;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Float getFloatJobValue() {
        return floatJobValue;
    }

    public void setFloatJobValue(Float floatJobValue) {
        this.floatJobValue = floatJobValue;
    }

    public Double getDoubleJobValue() {
        return doubleJobValue;
    }

    public void setDoubleJobValue(Double doubleJobValue) {
        this.doubleJobValue = doubleJobValue;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec time is：" + sf.format(date));
        //具体业务逻辑
//        System.out.println("业务逻辑");
        JobKey key=jobExecutionContext.getJobDetail().getKey();
        System.out.println("My name and group are"+key.getName()+":"+key.getGroup());
        TriggerKey triggerKey=jobExecutionContext.getTrigger().getKey();
        System.out.println("My trigger name and group are"+triggerKey.getName()+":"+triggerKey.getGroup());
//        JobDataMap jobDataMap=jobExecutionContext.getJobDetail().getJobDataMap();
//        JobDataMap triggerDataMap=jobExecutionContext.getTrigger().getJobDataMap();
//        String jobMessage=jobDataMap.getString("message");
//        Float floatValue=jobDataMap.getFloat("FloatJobValue");
//        System.out.println("jobMessage"+jobMessage+"floatValue"+floatValue);
//        System.out.println("triggerDataMap"+triggerDataMap.getString("message")+"DoubleTriggerValue"+triggerDataMap.getDouble("DoubleTriggerValue"));
//        System.out.println(jobExecutionContext.getMergedJobDataMap().getString("message"));
        System.out.println(message);
        System.out.println(floatJobValue);
        System.out.println(doubleJobValue);
    }
}
