package cn.cement.ysh.coderecord.server.TinyServer;

public interface IHandler {

    public HttpResponse handler(HttpRequest request);
}
