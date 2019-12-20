package cn.cement.ysh.coderecord.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

/**
 * @YSH 调度任务多线程配置
 */
@Slf4j@Configuration
public class ScheduleConfig implements SchedulingConfigurer{
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(3));
    }
    @Bean("TaskScheduler")
    public ThreadPoolTaskScheduler getCaseThreadPoolTaskScheduler(){
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setThreadNamePrefix("caseScheduler");
//        taskScheduler.setPoolSize(10); //默认poolSize=1;
        taskScheduler.setRemoveOnCancelPolicy(true);
        return  taskScheduler;
    }
}

