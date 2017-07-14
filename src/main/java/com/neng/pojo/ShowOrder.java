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
    private Date createTime;

    @Version
    private int version;

    private String goodName;
    private String goodPic;
    private String goodHeight;
    private String startLat;
    private String startLng;
    private String endLat;
    private String endLng;
    private String limitTime;
    private String status;
    private Long alwaysLocationId;
    private String content;
    private Double money;
    private Order order;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;



}
