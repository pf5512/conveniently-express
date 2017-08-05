package com.neng.config;

public interface ApiConf {

    //-----------------------------用户相关---------------------------
    String login = "api/v1/login";//用户登录+
    String register = "api/v1/register";//用户注册+
    String getPoints = "api/v1/getPoint"; //获取位置
    String getUserNumber = "api/v1/getUserNumber"; //获取用户数量
    String getUsers = "api/v1/getUsers"; //获取所有的用户
    String changeUserStatus = "api/v1/user/{userId}/{status}"; //修改用户状态

    String getAllMoney = "api/vi/user/getAllMoney";

    String user_add = "api/user"; // 添加用户
    String user_get = "api/user/{userId}"; // 获取用户信息


    //-----------------------------NeedController---------------------------
    String saveNeed = "api/v1/saveNeed"; //保存发布的需求
    String updateNeed = "api/v1/updateNeed"; //更新发布的需求
    String getNeeds = "api/v1/getNeeds"; //获取所有的发布
    String getNeedsByUser = "api/v1/getNeedByUser"; //获取用户发布的所有需求
    String getNeed = "api/v1/getNeed"; // 获取单个需求详情
    String deleteNeed = "api/v1/deleteNeed"; // 用户删除需求
    String getWeiJieDan = "api/v1/getWeiJieDan";
    String need_add = "api/need";

    //-----------------------------OrderController---------------------------
    String receiveOrder = "api/v1/receiveOrder"; // 接单
    String cancelOrder = "api/v1/cancelOrder"; // 取消接单
    String getOrders = "api/v1/getOrders"; // 获取所有的订单列表
    String getOrdersByUser = "api/v1/getOrdersByUser"; // 获取所有的订单列表
    String getOrderItems = "api/v1/getOrderItems/{id}"; // 获取所有的订单项
    String getOrderItem = "api/v1/getOrderItem"; // 获取单个订单详情
    String order_search = "api/order"; // 查询订单
    String getWeiZhiFu = "api/v1/getWeiZhiFu";
    String getYiZhiFu = "api/v1/getYiZhiFu";

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

    //-----------------------------AdvertiseController---------------------------
    String saveAdvertise = "api/v1/advertise"; // 保存广告
    String updateAdvertise = "api/v1/advertise"; // 更新广告
    String listAdvertises = "api/v1/advertise"; // 广告列表
    String getAdvertise = "api/v1/advertise/{id}"; // 获得单个广告
    String deleteAdvertise = "api/v1/advertise/{id}"; // 获得单个广告


    //-----------------------------客服相关---------------------------
    String getMessage = "api/v1/getMessage"; //获取所有任务



    //----------------------------页面数据相关----------------------------
    String index = "index"; //主页
    String page = "page"; //分页数据
    String student = "student"; //学生信息
    String teacher = "teacher"; //老师信息
    String course = "course"; //课程信息


    //----------------------------页面相关----------------------------
    String view_content = "view"; //主要显示界面
    String fontend = "shared/content"; //主页
    String user_list = "user/list"; //用户列表
    String order_list = "order/list"; //订单列表
    String need_list = "need/list"; //订单列表
    String model_info = "model/content";
    String advertise_list = "advertise/list"; //广告管理

    String breadCump = "info";
    String user = "用户管理";
    String order = "订单管理";
    String need = "需求管理";
    String advertise = "广告管理";
    String infoManagers = "信息管理";

    String users = "users";
    String advertises = "advertises";
    String orders = "orders";
    String needs = "needs";
    String models = "models";


    //----------------------------AliPay----------------------------
    String getWay = "/getWay";
    String prepareAliPay = "/prepareAliPay";
    String searchByCondi = "/searchByCondi";

}
