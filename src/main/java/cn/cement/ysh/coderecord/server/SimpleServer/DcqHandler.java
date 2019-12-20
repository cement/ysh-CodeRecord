package cn.cement.ysh.coderecord.server.SimpleServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

@Slf4j
public class DcqHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) {
//        SimpleServer.threadPool.execute(() -> {
            log.info("====== DcqHandler ======");
            try {
                URI requestURI = exchange.getRequestURI();
                log.info("====== DcqHandler ======{}",requestURI);
                exchange.getResponseHeaders().set("aaa","aaaaaaaaaaaaaa");
                exchange.sendResponseHeaders(200, 0);
                OutputStream os = exchange.getResponseBody();
                os.write("===DcqHandler===".getBytes());
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

//        });

    }


}