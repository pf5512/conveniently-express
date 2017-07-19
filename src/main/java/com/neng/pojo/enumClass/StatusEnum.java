package com.neng.pojo.enumClass;

/**
 * Created by nengneng on 2017/6/15.
 */
public enum StatusEnum {

    ACTIVE(1,"已激活"),
    FREEZE(0,"已冻结"),
    PAY(1,"已支付"),
    NOT_PAY(0,"未支付"),
    ORDER_RECEIVING(1,"已接单"),
    ORDER_NOT_RECEIVING(0,"未接单");


    private int code;
    private String content;
    StatusEnum(int code, String content){
        this.code = code;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
