package com.neng.pojo;

import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by nengneng on 2017/6/5.
 */

@Data
@Entity
@Table(name = "t_user")
public class User implements  Serializable {

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

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
//    private List<Authority> authorities;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        //  需将 List<Authority> 转成 List<SimpleGrantedAuthority>，否则前端拿不到角色列表名称
//        List<SimpleGrantedAuthority> simpleAuthorities = new ArrayList<>();
//        for(GrantedAuthority authority : this.authorities){
//            simpleAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
//        }
//        return simpleAuthorities;
//    }
//
//    public void setAuthorities(List<Authority> authorities) {
//        this.authorities = authorities;
//    }
//
//    @Override
//    public String getUsername() {
//        return name;
//    }
//
//    public void setUsername(String username) {
//        this.name = username;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
