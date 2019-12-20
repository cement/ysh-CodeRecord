package cn.cement.ysh.coderecord.entity;

import lombok.Builder;

@Builder
public class RResult {
    public boolean success;

    public String errorMsg ;

    public String result ;
}