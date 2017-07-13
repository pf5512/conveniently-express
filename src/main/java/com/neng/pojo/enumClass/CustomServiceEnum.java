package com.neng.pojo.enumClass;

/**
 * Created by nengneng on 2017/6/15.
 */
public enum CustomServiceEnum {

    ONE(1,"你点击下面发布按钮，按照提示填写完成，点击发布按钮进行发布。"),
    TWO(2,"点击接单，点击地图上的任务点，点击查看详情，转到详情页，点击预约"),
    THREE(3,"点击好友栏，点击好友，进行聊天。");


    private int code;
    private String content;
    CustomServiceEnum(int code,String content){
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

    public static void main(String[] args) {
        System.out.println(CustomServiceEnum.ONE.getContent());
    }
}
