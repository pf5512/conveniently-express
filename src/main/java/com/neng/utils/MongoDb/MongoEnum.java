package com.neng.utils.MongoDb;

/**
 * Created by zhubuqing on 2017/7/16.
 */
public enum MongoEnum {
    MYHOST("127.0.0.1"),
    USE_HOST("115.159.193.237");
    private String host;

    MongoEnum(String host) {
        this.host = host;
    }

    public String host() {
        return this.host;
    }
}
