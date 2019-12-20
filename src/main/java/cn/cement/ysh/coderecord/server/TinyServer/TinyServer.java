package cn.cement.ysh.coderecord.server.TinyServer;


import com.alibaba.fastjson.JSON;
import io.netty.handler.codec.http.HttpResponseEncoder;
import scala.math.Ordering;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class TinyServer {
    private static final Integer port = 5555;//HTTP默认端口80


    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            //建立服务器Socket,监听客户端请求
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running on port:" + serverSocket.getLocalPort());
            //死循环不间断监听客户端请求
            while (true) {
                final Socket socket = serverSocket.accept();
                System.out.println("biuld a new tcp link with client,the cient address:" + socket.getInetAddress() + ":" + socket.getPort());
                //并发处理HTTP客户端请求
                handler(socket);
            }
        } catch (IOException e) {
            System.err.println("server start failed!" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void handler(Socket socket) throws IOException {
        new Thread(new Runnable() {

            @Override
            public void run() {
                HttpSession session = new HttpSession(socket);
                HttpRequest request = session.getRequest();
                HttpResponse response = session.getResponse();


                try{

                    InputStream inputStream = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    String line = reader.readLine();
                    System.out.println(line);
                    String[] firstLine = line.split(" ");
                    //TODO 请求行
                    System.out.println(Arrays.asList(firstLine));
                    request.setMethod(firstLine[0]);
                    request.setUri(URI.create(firstLine[1]));
                    request.setProtocol(firstLine[2]);
                    while ((line = reader.readLine()) !=null && !line.equals("")) {
                            //TODO 头部行
                            System.out.println(line);
                            String[] headLine = line.split(": ");
                            request.getHeader().put(headLine[0], Arrays.asList(headLine[1].split(",")));

                    }



//                    while ((line = reader.readLine()) != null) {
//                        System.out.println(line);
//                        request.getBody().getBuffer().append(line);
//                    }


                    response.setProtocol("HTTP/1.1");
                    response.getStatus().setCode(200).setDescribe("OK");
                    response.getHeader().put("Content-type",Arrays.asList("application/json"));
                    response.getHeader().put("Host",Arrays.asList(InetAddress.getLocalHost().getHostAddress()));
                    response.getHeader().put("Date",Arrays.asList(new Date().toString()));
                    response.getHeader().put("Set-Cookie",Arrays.asList("a=aaa"));
                    String resultBody = JSON.toJSONString(session);

                    response.getBody().getBuffer().append(resultBody);
                    response.getHeader().put("Content-length",Arrays.asList(String.valueOf(response.getBody().getBuffer().length())));

                    response.write();


                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
