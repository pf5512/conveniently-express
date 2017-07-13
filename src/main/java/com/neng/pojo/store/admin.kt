//package com.neng.pojo.store
//
//import java.util.*
//import javax.persistence.Entity
//import javax.persistence.GeneratedValue
//import javax.persistence.GenerationType
//import javax.persistence.Id
//
///**
// * Created by nengneng on 2017/6/11.
// */
//
//
//@Entity
//data class Admin(
//        var name: String,
//        var password: String,
//        @Id @GeneratedValue(strategy = GenerationType.AUTO)
//        var id: Long = 0,
//        var role: String
//)
//
//
//@Entity
//data class deliverAdmin(
//        var name: String,
//        var password: String,
//        @Id @GeneratedValue(strategy = GenerationType.AUTO)
//        var id: Long = 0,
//        var role: String,
//        var wordTime: Date,
//        var employTime: Date
//)
//
//
//@Entity
//data class Users(
//        var name: String,
//        var password: String,
//        @Id @GeneratedValue(strategy = GenerationType.AUTO)
//        var id: Long = 0,
//        var rentStore: String,
//        var good: String,
//        var registerTime: Date
//)
//
//
//@Entity
//data class Store(
//        var number: String,
//        var address: String,
//        @Id @GeneratedValue(strategy = GenerationType.AUTO)
//        var id: Long = 0,
//        var useCount: Double,
//        var type: String,
//        var userId: Long,
//        var info: String
//)
//
//@Entity
//data class OutStoreInfos(
//        var storeId: Long,
//        @Id @GeneratedValue(strategy = GenerationType.AUTO)
//        var id: Long = 0,
//        var time: Date,
//        var userId: Long,
//        var storeInfo: Long
//)
//
//
