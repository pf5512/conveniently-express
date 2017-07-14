package com.neng.pojo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by nengneng on 2017/6/5.
 */

@Data
@Entity
@Table(name = "t_always_location")
public class AlwaysLocation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /** ID **/
    private long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    /** 创建时间 **/
    private Date createTime;

    @Version
    /** 版本号 **/
    private int version;

    /** 位置（浙江省宁波市鄞州区高桥镇宁波大红鹰学院） **/
    private String location;

    /** 纬度 **/
    private String lat;

    /** 经度 **/
    private String lng;

    /** 类型 **/
    private String type;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    /** 用户 **/
    private User user;
}
