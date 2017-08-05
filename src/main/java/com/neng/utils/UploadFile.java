package com.neng.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * Created by nengneng on 2017/8/1.
 */
public class UploadFile {

    private static final String UPLOADED_URL = "http://ou06lv333.bkt.clouddn.com/";

    private final String accessKey = "adcXzTBYWeo6nDFuqXjkxfKoPIG70yMqnnG5RVdG";

    private final String secretKey = "kiQ2sTiGJ4N36GjHEv_uaWl9rYMwT40nMq2qEI73";

    private final String bucket = "image";


    public String creatAuth() {
        Auth auth = Auth.create(accessKey, secretKey);
        StringMap putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        long expireSeconds = 3600;
        String upToken = auth.uploadToken(bucket,null,expireSeconds,putPolicy);
        return upToken;
    }




    public String upload(byte[] uploadBytes,String fileName){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);

        String upTokken = creatAuth();

        try {
            Response response = uploadManager.put(uploadBytes, fileName, upTokken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        } catch (QiniuException ex) {
            Response r = ex.response;
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
            }
        }
        System.out.println(UPLOADED_URL+fileName);
        return UPLOADED_URL + fileName;

    }

}
