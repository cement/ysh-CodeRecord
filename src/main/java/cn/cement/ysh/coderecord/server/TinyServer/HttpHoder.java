package cn.cement.ysh.coderecord.server.TinyServer;


import java.net.Socket;
import java.net.URI;

public class HttpHoder {
    private Socket socket;


    public HttpHoder(Socket socket) {
        this.socket = socket;
    }

    private String protocol;
    private URI uri;
    private HttpHeader header =new HttpHeader();
    private HttpBody body =new HttpBody();

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public HttpHeader getHeader() {
        return header;
    }

    public void setHeader(HttpHeader header) {
        this.header = header;
    }

    public HttpBody getBody() {
        return body;
    }

    public void setBody(HttpBody body) {
        this.body = body;
    }
}
