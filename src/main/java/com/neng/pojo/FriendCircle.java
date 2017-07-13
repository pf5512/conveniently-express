package com.neng.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by nengneng on 2017/6/5.
 */

@Data
@Entity
@Table(name = "t_friend_circle")
public class FriendCircle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//id

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createTime;


    @Version
    private Integer version;

    private String content;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;




}
