package cn.cement.ysh.coderecord.common.Entry;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponesModel {
    private Object data;
    private int code;
    private String msg;

}
