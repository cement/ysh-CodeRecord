package cn.cement.ysh.coderecord.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Order(0)
@Component
public class AppRunnerConfig implements ApplicationRunner, CommandLineRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("=== My ApplicationRunner ===", Arrays.asList(args));
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("=== My CommandLineRunner ===", Arrays.asList(args));
    }
}
