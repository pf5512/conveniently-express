package com.neng.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nengneng on 2017/8/5.
 */

@Data
@Entity
@Table(name = "t_advertise")
public class Advertise {


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

    private String title;

    private String content;
}
