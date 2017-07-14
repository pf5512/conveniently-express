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
@Table(name = "t_order_items")
public class OrderItems implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//id


    @Temporal(value = TemporalType.DATE)
    private Date createTime;//创建时间

    @Version
    private int version;//版本号

    @Temporal(value = TemporalType.DATE)
    private Date tradeTime;//交易时间

    private String detailName;//单项名称

    private Double detailPrice;//单项价格

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = Order.class)
    @JoinColumn(name = "order_id")
    private Order order;//订单



}
