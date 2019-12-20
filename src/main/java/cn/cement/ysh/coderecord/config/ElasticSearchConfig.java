package cn.cement.ysh.coderecord.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ElasticSearchConfig {
    /*解决启动无法注入ElasticSearchTemplate问题*/
    @PostConstruct
   public void init() {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }
}
