package cn.cement.ysh.coderecord.server.TinyServer;


public class ResponseStatus {
    private int code = 200;
    private String describe = "OK";

    public int getCode() {
        return code;
    }

    public ResponseStatus setCode(int code) {
        this.code = code;
        return this;
    }

    public String getDescribe() {
        return describe;
    }

    public ResponseStatus setDescribe(String describe) {
        this.describe = describe;
        return this;
    }
}
