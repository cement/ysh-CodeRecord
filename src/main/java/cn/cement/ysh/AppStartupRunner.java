package cn.cement.ysh;


import org.elasticsearch.watcher.FileWatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.util.concurrent.ScheduledFuture;

@Configuration
public class AppStartupRunner implements ApplicationRunner, CommandLineRunner {




//    @Autowired
//    @Qualifier("taskScheduler")
//    private ThreadPoolTaskScheduler taskScheduler;



    @Override
    public void run(ApplicationArguments args) throws Exception {

//        ScheduledFuture<?> schedule = taskScheduler.schedule(() -> {
//            transfromTask.dataTransfromTiming();
//        }, new CronTrigger(AppConfig.cron));

    }

    @Override
    public void run(String... args) throws Exception {

        /*hutool文件监控，有一个问题，就是文件正在写入就会触发 onCreate，onModify又会触发多次,所以此次暂时使用定时任务实现*/
//        WatchMonitor monitor = WatchMonitor.create(AppConfig.watchPathRoot,WatchMonitor.EVENTS_ALL);
//        monitor.setWatcher(new DelayWatcher(fileWatcher, 500));
//        monitor.setMaxDepth(AppConfig.watchMaxdepth);
//        monitor.start();

//        WatchService watchService = FileSystems.getDefault().newWatchService();
//        Path path = Paths.get("");
//        WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
//        for (;;) {
//            for (WatchEvent<?> event: watchKey.pollEvents()) {
//
//            }
//            boolean valid = watchKey.reset();
//            if (!valid) {
//                //todo
//            }
//        }

    }
}
