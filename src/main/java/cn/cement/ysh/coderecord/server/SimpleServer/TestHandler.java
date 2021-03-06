package cn.cement.ysh.coderecord.server.SimpleServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TestHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) {

           log.info("====== TestHandler ======{}",exchange.getRemoteAddress());
//        SimpleServer.threadPool.execute(new Runnable() {
//            @Override
//            public void run() {
                try {
                    String response = "hello world!";
                    //获得查询字符串(get)
                    String queryString = exchange.getRequestURI().getQuery();
                    Map<String, String> queryStringInfo = formData2Dic(queryString);
                    //获得表单提交数据(post)
                    String postString = IOUtils.toString(exchange.getRequestBody());
                    Map<String, String> postInfo = formData2Dic(postString);

                    exchange.sendResponseHeaders(200, 0);
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                } catch (IOException ie) {
                    ie.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
//            }
//        });

    }

    public static Map<String, String> formData2Dic(String formData) {
        Map<String, String> result = new HashMap<>();
        if (formData == null || formData.trim().length() == 0) {
            return result;
        }
        final String[] items = formData.split("&");
        Arrays.stream(items).forEach(item -> {
            final String[] keyAndVal = item.split("=");
            if (keyAndVal.length == 2) {
                try {
                    final String key = URLDecoder.decode(keyAndVal[0], "utf8");
                    final String val = URLDecoder.decode(keyAndVal[1], "utf8");
                    result.put(key, val);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
        return result;
    }


}