package cn.cement.ysh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import sun.misc.Signal;

@Slf4j
@Configuration
@Order(0)
public class AppShutdownHook implements ApplicationRunner, CommandLineRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("******  程序启动完成  ******  ");

        Signal sg = new Signal("TERM"); // kill -15 pid
        // 监听信号量
        Signal.handle(sg, signal -> {
            System.out.println("====== signal handle ======:  " + signal.getName());
            System.exit(0);
        });
        // 注册关闭钩子
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                // 在关闭钩子中执行收尾工作
                // 注意事项：
                // 1.在这里执行的动作不能耗时太久
                // 2.不能在这里再执行注册，移除关闭钩子的操作
                // 3 不能在这里调用System.exit()
                log.info("====== do shutdown hook ======");
                log.info("******  程序运行结束  ******  ");
            }
        });
    }

    @Override
    public void run(String... args) throws Exception {
        //todo do nothing
    }
}
