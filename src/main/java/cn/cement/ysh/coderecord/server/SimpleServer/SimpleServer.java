package cn.cement.ysh.coderecord.server.SimpleServer;


import com.sun.net.httpserver.HttpServer;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SimpleServer {

    protected final static  ExecutorService threadPool = Executors.newWorkStealingPool();

    public static void main(String[] arg) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8001), 100);
        server.createContext("/test", new TestHandler());
        server.createContext("/dcq", new DcqHandler());
        server.setExecutor(threadPool);
        server.start();
        log.info("server is started at {}",server.getAddress());
    }



}