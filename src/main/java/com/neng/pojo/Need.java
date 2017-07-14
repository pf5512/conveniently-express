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
    private Date createTime;

    @Version
    private int version;

    private String goodName;
    private Double goodPrice;
    private String goodPic;
    private String goodHeight;
    private String startLat;
    private String startLng;
    private String endLat;
    private String endLng;
    private String limitTime;
    private Long clientId;
    private String clientTime;
    private String cilentPhone;
    private String clientHeadPic;
    private Long principalId;
    private String principalName;
    private String principalPhone;
    private String principalHeadPic;
    private String status;
    private Long alwaysLocationId;
    private String content;
    private Double money;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;
}
