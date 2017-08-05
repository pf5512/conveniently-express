package com.neng.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by nengneng on 2017/8/5.
 */
@Data
@Entity
@Table(name = "t_picture")
public class Picture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//id


    @Temporal(value = TemporalType.DATE)
    private Date createTime;//创建时间

    @Version
    private int version;//版本号

    private String url;

    private int width;

    private int height;
}
