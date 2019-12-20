package cn.cement.ysh.coderecord.common.Entry;

import lombok.Builder;

@Builder
public class ResponesException extends RuntimeException {
    private Object  eData;
    private int eCode;
    private String eMessage;
}
