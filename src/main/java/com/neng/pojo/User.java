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
@Table(name = "t_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//id

    @Temporal(value = TemporalType.DATE)
    private Date createTime;//创建时间


    @Version
    private int version;//版本号

    @Column(nullable = false, length = 40)
    private String name;//用户名

    @Column(nullable = false, length = 32)
    private String password;//密码

    private String sex;//性别
    private String phone;//手机号
    private String address;//地址
    private String headPic;//头像
    private String realName;//真实姓名
    private String type;//类型（暂时没有作用）
    private String idCardCorrectPic;//身份证正面照
    private String idCardOppositePic;//身份证反面照
    private Date birthday;//生日
    private int status;//状态






}
