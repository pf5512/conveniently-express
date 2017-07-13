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


    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createTime;

    @Version
    private int version;

    private String number;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date tradeTime;

    private Long needId;

    private Double allPrice;

//    private Long alwaysLocationId;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "order")
    private Set<OrderItems> orderItems = new HashSet<>();//订单项目集合

    private Need need;


}
