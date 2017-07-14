package com.neng.config;

public interface ApiConf {

    //-----------------------------用户相关---------------------------
    String login="api/v1/login";//用户登录+
    String register="api/v1/register";//用户注册+
    String getPoints = "api/v1/getPoint"; //获取位置


    //-----------------------------NeedController---------------------------
    String saveNeed = "api/v1/saveNeed"; //保存发布的需求
    String updateNeed = "api/v1/updateNeed"; //更新发布的需求
    String getNeeds = "api/v1/getNeeds"; //获取所有的发布
    String getNeedsByUser = "api/v1/getNeedByUser"; //获取用户发布的所有需求
    String getNeed = "api/v1/getNeed"; // 获取单个需求详情
    String deleteNeed = "api/v1/deleteNeed"; // 用户删除需求



    //-----------------------------OrderController---------------------------
    String receiveOrder = "api/v1/receiveOrder"; // 接单
    String cancelOrder = "api/v1/cancelOrder"; // 取消接单
    String getOrders = "api/v1/getOrders"; // 获取所有的订单列表
    String getOrderItems = "api/v1/getOrderItems"; // 获取所有的订单项
    String getOrderItem = "api/v1/getOrderItem"; // 获取单个订单详情


    //-----------------------------ShowOrderController---------------------------
    String saveShowOrder = "api/v1/saveShowOrder"; //保存晒单
    String getShowOrders = "api/v1/getShowOrders"; //获取所有的晒单
    String getShowOrderByBuyerId = "api/v1/getShowOrderByBuyerId"; //获取用户的晒单数据
    String getShowOrderBySalerId = "api/v1/getShowOrderBySalerId"; //获取用户的晒单数据
    String deleteShowOrder = "api/v1/deleteShowOrder"; // 删除晒单数据


    //-----------------------------FriendCircleController---------------------------
    String saveFriendCirle = "api/v1/saveFriendCircle"; // 用户发布朋友圈
    String getFriendCircles = "api/v1/getFriendCircle"; // 获取所有的朋友圈数据
    String getFriendCircleByUser = "api/v1/getFriendCircleByUser"; //获取用户的朋友圈数据
    String deleteFriendCircle = "api/v1/deleteFriendCircle"; // 删除朋友圈


    //-----------------------------AddressController---------------------------
    String saveHomeAddress = "api/v1/saveAddress"; // 保存家庭地址
    String getHomeAddresses = "api/v1/getAddresses"; // 获取所有的地址列表
    String updateHomeAddress = "api/v1/updateAddress"; // 更新地址
    String deleteHomeAddress = "api/v1/deleteAddress"; // 删除地址





    //-----------------------------客服相关---------------------------
    String getMessage = "api/v1/getMessage"; //获取所有任务
}
