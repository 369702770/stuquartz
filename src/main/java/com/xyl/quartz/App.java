package com.xyl.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;

/**
 * Hello world!
 *
 */
@ComponentScan(basePackages = {"com.xyl.quartz"})
@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
        // 系统默认的时区
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(App.class, args);
    }
}
