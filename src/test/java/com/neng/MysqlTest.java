//package com.neng;
//
//import com.neng.pojo.User;
//import com.neng.repository.UserRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.util.Assert;
//
//import java.util.Date;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MysqlTest {
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    RoleRepository roleRepository;
//
//    @Before
//    public void initData(){
//
//
//        Role role = new Role();
//        role.setName("admin");
//        roleRepository.save(role);
//        Assert.notNull(role.getId());
//
//        User user = new User();
//
//        user.setCreateTime(new Date());
//        userRepository.save(user);
//        Assert.notNull(user.getId());
//    }
//
//    @Test
//    public void insertUserRoles(){
//        User user = userRepository.findUserByName("user");
//        Assert.notNull(user);
//
//        List<Role> roles = roleRepository.findAll();
//        Assert.notNull(roles);
//        user.setRoles(roles);
//        userRepository.save(user);
//    }
//}
