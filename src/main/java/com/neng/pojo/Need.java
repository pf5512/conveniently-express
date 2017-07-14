package com.neng.pojo;


import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZF on 2017-06-07.
 */
@Data
@Entity
@Table(name = "t_need")
public class Need implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//id

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createTime;//创建时间

    @Version
    private int version;//版本

    private String goodName;//商品名称
    private Double goodPrice;//商品价格
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

    /**
     * 发布的User
     */
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;//买家
}
