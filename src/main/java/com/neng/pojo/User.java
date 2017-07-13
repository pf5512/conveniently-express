package com.neng.pojo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by nengneng on 2017/6/5.
 */

@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//id

    @Temporal(value = TemporalType.DATE)
    private Date createTime;


    @Version
    private int version;

    @Column(nullable = false, length = 40)
    private String username;//用户名

    @Column(nullable = false, length = 32)
    private String password;//密码

    private String sex;
    private String phone;
    private String address;
    private String headPic;
    private String realName;
    private String type;
    private String idCardCorrectPic;
    private String idCardOppositePic;
    private Date birthday;
}
