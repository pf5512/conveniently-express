//package com.neng.service;
//
//import com.neng.pojo.User;
//import com.neng.repository.UserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//
///**
// * Created by nengneng on 2017/6/6.
// */
//@Service
//public class InitServiceImpl {
//
//    private static final Logger logger= LoggerFactory.getLogger(InitServiceImpl.class);
//
//    private UserRepository userRepository;
//
//    private PointRepository pointRepository;
//
//    @Autowired
//    public InitServiceImpl(UserRepository userRepository, PointRepository pointRepository) {
//        this.pointRepository = pointRepository;
//        this.userRepository = userRepository;
//    }
//
//
//    @Transactional
//    @PostConstruct
//    public void executeInit() {
//        logger.info("----------开始初始化数据-----------");
//        initUserData();
//    }
//
//    private void initUserData() {
//        pointRepository.deleteAll();
//        userRepository.deleteAll();
//        logger.info("delete all success");
//        User neng = userRepository.findUserByUsername("1");
//        if (neng == null) {
////            String pass= EncryptUtils.EncoderByMd5("1");
//            userRepository.save(new UserBuilder()
//                            .username("1")
//                            .password("1")
//                            .build()
//                                );
//        }
//        neng = userRepository.findUserByUsername("neng");
//        System.out.print("找到了能" + "******************");
//        MyPoint myPoint1 = new MyPoint();
//        myPoint1.setLatitude(29.8889793746);
//        myPoint1.setLongitude(121.4823096983);
//        myPoint1.setAddress("宁波大红鹰学院");
//        myPoint1.setUser(neng);
//
//        logger.info("----------开始初始化数据-----------");
//        MyPoint myPoint2 = new MyPoint();
//        myPoint2.setLatitude(29.8900212334);
//        myPoint2.setLongitude(121.4890044920);
//        myPoint2.setAddress("宁波大红鹰学院");
//
//        myPoint2.setUser(neng);
//
//        MyPoint myPoint3 = new MyPoint();
//        myPoint3.setLatitude(29.8950997560);
//        myPoint3.setLongitude(121.4760977802);
//        myPoint3.setAddress("宁波大红鹰学院");
//
//        myPoint3.setUser(neng);
//
//        MyPoint myPoint4 = new MyPoint();
//        myPoint4.setLatitude(29.8986545197);
//        myPoint4.setLongitude(121.4855802310);
//        myPoint4.setAddress("宁波大红鹰学院");
//
//        myPoint4.setUser(neng);
//
//        MyPoint myPoint5 = new MyPoint();
//        myPoint5.setLatitude(29.9063030939);
//        myPoint5.setLongitude(121.4689363574);
//        myPoint5.setAddress("宁波大红鹰学院");
//
//        myPoint5.setUser(neng);
//
//        pointRepository.save(myPoint1);
//        logger.info("----------开始初始化数据myPoint1-----------");
//        pointRepository.save(myPoint2);
//        logger.info("----------开始初始化数据myPoint2-----------");
//        pointRepository.save(myPoint3);
//        logger.info("----------开始初始化数据myPoint3-----------");
//        pointRepository.save(myPoint4);
//        logger.info("----------开始初始化数据myPoint4-----------");
//        pointRepository.save(myPoint5);
//        logger.info("----------开始初始化数据myPoint5-----------");
//
//        logger.info("----------初始化数据成功-----------");
//
//    }
//}
