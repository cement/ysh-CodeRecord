package cn.cement.ysh.coderecord.server.TinyServer;

import lombok.Data;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;


public class HttpResponse extends HttpHoder{

    public static final  String SP = "";

     private ResponseStatus status = new ResponseStatus();

     private PrintWriter writer;

    public HttpResponse(Socket socket) {
        super(socket);
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }


    public PrintWriter getWriter() throws IOException {
        if (writer == null){
            writer = new PrintWriter(new OutputStreamWriter(getSocket().getOutputStream()));
        }
        return writer;
    }

    public void write() throws IOException {
        PrintWriter writer = getWriter();
        writer.println(getProtocol()+SP+status.getCode()+SP+status.getDescribe());

        HttpHeader header = getHeader();
        header.forEach((k,v)->{
            String delimit="Set-Cookie".equalsIgnoreCase(k)?";":":";
            String vlist = v.stream().collect(Collectors.joining(delimit));
            writer.println(k+": "+vlist);
        });
        writer.println();
        String s = getBody().getBuffer().toString();
        System.out.println(s);
        writer.println(getBody().getBuffer().toString());
        writer.flush();
        writer.close();
     }



}
