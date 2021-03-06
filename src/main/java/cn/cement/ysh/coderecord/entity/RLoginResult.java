package cn.cement.ysh.coderecord.entity;

import lombok.Builder;

@Builder
public class RLoginResult {

    public int id;

    public String userName;

    public String userIcon;
    /**
     * 待支付数目
     */
    public int waitPayCount;
    /**
     * 待收货数目
     */
    public int waitReceiveCount;
    /**
     * 用户等级
     */
    public int userLevel;

}
