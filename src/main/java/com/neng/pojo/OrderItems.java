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


    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createTime;

    @Version
    private int version;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date tradeTime;

    private String detailName;

    private Double detailPrice;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = Order.class)
    @JoinColumn(name = "order_id")
    private Order order;

    private Need need;


}
