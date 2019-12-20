package cn.cement.ysh.coderecord.server.TinyServer;

import lombok.Data;

import java.net.Socket;

@Data
public class HttpSession {

    private Socket socket;
    private HttpRequest request;
    private HttpResponse response ;

    public HttpSession(Socket socket) {
        this.socket = socket;
        this.request = new HttpRequest(socket);
        this.response = new HttpResponse(socket);
    }



}
