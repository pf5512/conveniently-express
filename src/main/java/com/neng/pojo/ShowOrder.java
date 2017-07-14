package com.neng.pojo;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZF on 2017-06-07.
 */
@Data
@Entity
@Table(name = "t_order_show")
public class ShowOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//id


    @Temporal(value = TemporalType.DATE)
    private Date createTime;//创建时间

    @Version
    private int version;//版本号

    private String goodName;//商品名称
    private String goodPic;//商品图片
    private String goodHeight;//商品重量
    private String startLat;//开始纬度
    private String startLng;//开始经度
    private String endLat;//结束纬度
    private String endLng;//结束经度
    private String limitTime;//限制时间
    private String status;//状态
    private Long alwaysLocationId;//常用地点ID
    private String content;//文本
    private Double money;//佣金
    private long needId;//需求ID
    private long orderId;//订单ID
    private long buyerId;//买家ID
    private String buyerUsername;//买家用户名
    private String buyerSex;//买家性别
    private String buyerPhone;//买家手机号
    private String buyerAddress;//买家地址
    private String buyerHeadPic;//买家头像
    private long salerId;//卖家ID
    private String salerUsername;//卖家用户名
    private String salerSex;//卖家性别
    private String salerPhone;//卖家手机号
    private String salerAddress;//卖家地址
    private String salerHeadPic;//卖家头像
}
