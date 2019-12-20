package cn.cement.ysh.coderecord.server.TinyServer;

import lombok.Data;

import java.net.Socket;



public class HttpRequest  extends HttpHoder{

    public HttpRequest(Socket socket) {
        super(socket);
    }

    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
