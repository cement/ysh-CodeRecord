package cn.cement.ysh.coderecord.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.util.concurrent.ScheduledFuture;

public class AdvertDistributeTask implements Runnable{

    @Value("${advert.distribute.cron:1 0 0 1/1 * ?}")
    private String cron;

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    private ScheduledFuture<?> taskFuture;




    public ScheduledFuture<?> startDistributeTask(){
        taskFuture = taskScheduler.schedule(this, new CronTrigger(cron));
        return taskFuture;
    }
   public boolean stopDistributeTask(){
       if (taskFuture != null && !taskFuture.isCancelled()&& !taskFuture.isDone()) {
           return taskFuture.cancel(true);
       }
       return false;
   }

    @Override
    public void run() {

    }
}
