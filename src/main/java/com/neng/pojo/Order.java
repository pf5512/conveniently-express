package com.neng.pojo;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ZF on 2017-06-07.
 */
@Data
@Entity
@Table(name = "t_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//id


    @Temporal(value = TemporalType.DATE)
    private Date createTime;//创建时间

    @Version
    private int version;//版本号

    private String number;//订单编号
    @Temporal(value = TemporalType.DATE)
    private Date tradeTime;//交易时间
    private Double allPrice;//总价格
    /**
     * 接受订单的User
     */
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;//用户


    private Need need;//需求

    private int status;
}
