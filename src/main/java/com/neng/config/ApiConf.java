package com.neng.config;

public interface ApiConf {

    //-----------------------------用户相关---------------------------
    String login="api/v1/login";//用户登录+
    String register="api/v1/register";//用户注册+
    String getPoints = "api/v1/getPoint"; //获取位置
    String saveTask = "api/v1/saveTask"; //保存任务
    String getTasks = "api/v1/getTasks"; //获取所有任务
    String saveHomeAddress = "";


    //-----------------------------客服相关---------------------------
    String getMessage = "api/v1/getMessage"; //获取所有任务
}
