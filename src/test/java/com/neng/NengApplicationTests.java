package com.neng;

import com.neng.pojo.*;
import com.neng.repository.*;
import com.neng.service.inner.AlwaysLocationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NengApplicationTests {

    @Autowired
    NeedRepository needRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AlwaysLocationRepository alwaysLocationRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemsRepository orderItemsRepository;

    @Autowired
    AlwaysLocationService alwaysLocationService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void findNeedByUserId() {
//		List<Need> needs = needRepository.findByUserId(1L);
//		User user = new User();
//		user.setUsername("maneng");
//		user.setPassword("123");
//		User u = userRepository.save(user);
        User u = userRepository.findOne(1L);
        List<Need> needs = needRepository.findByUser(u);
        Assert.assertEquals(3, needs.size());
//		Assert.assertNotNull(u);

//		Assert.assertNotNull(needs);
    }

    @Test
    public void findLocationByUserId() {
//		List<Need> needs = needRepository.findByUserId(1L);
//		User user = new User();
//		user.setUsername("maneng");
//		user.setPassword("123");
//		User u = userRepository.save(user);
        User u = userRepository.findOne(1L);
        List<AlwaysLocation> alwaysLocations = alwaysLocationRepository.getByUser(u);
        Assert.assertEquals(2, alwaysLocations.size());
//		Assert.assertNotNull(u);

//		Assert.assertNotNull(needs);
    }


    /**
     * 测试保存订单
     */
    @Test
    public void saveOrders() {
        OrderItems orderItems2 = new OrderItems();
        orderItems2.setDetailName("huawei shouji123213 ");
        OrderItems orderItems1 = new OrderItems();
        orderItems1.setDetailName("huawei shouji ");

        Set<OrderItems> orderItemsAll = new HashSet<OrderItems>();
        orderItemsAll.add(orderItems1);
        orderItemsAll.add(orderItems2);


        Order order = new Order();
        order.setAllPrice(1100.00);
        order.setOrderItems(orderItemsAll);
        Order order1 = orderRepository.save(order);

        orderItems1.setOrder(order1);
        orderItems2.setOrder(order1);
        orderItemsRepository.saveAndFlush(orderItems1);
        orderItemsRepository.saveAndFlush(orderItems2);
        Assert.assertEquals(2, order1.getOrderItems().size());


//        }

    }

    @Test
    public void getByUser() {
        User user = userRepository.getOne(Long.valueOf(1));
        List<AlwaysLocation> alwaysLocations = alwaysLocationRepository.getByUser(user);
        Assert.assertEquals(7, alwaysLocations.size());
    }


    @Test
    public void saveAndFlushAlwaysLocation() {
        String location = "浙江省";
        String lat = "123.123";
        String lng = "30";
        User user = userRepository.getOne(Long.valueOf(1));
        String type = "HOME";

        AlwaysLocation alwaysLocation = new AlwaysLocation();
        alwaysLocation.setLocation(location);
        alwaysLocation.setLat(lat);
        alwaysLocation.setLng(lng);
        alwaysLocation.setUser(user);
        alwaysLocation.setType(type);

        alwaysLocationService.save(alwaysLocation);
    }


    @Test
    public void getById() {
        AlwaysLocation alwaysLocation = alwaysLocationRepository.getOne(Long.valueOf(7));
    }

    @Test
    public void saveUser() {
        User u = new User();
        u.setPassword("15151");
        u.setUsername("f4sdaf45s");
        User save = userRepository.save(u);

        Assert.assertNotNull(save);

    }

}
