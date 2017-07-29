package com.neng.utils;

import com.aliyun.oss.OSSClient;

import java.io.FileNotFoundException;
import java.io.InputStream;


public class UploadOSSUtil {
 public UploadOSSUtil(){}
 
 public static void uploadImgAliyun(InputStream inputStream ,String savePath)
 throws FileNotFoundException{

  OSSClient client = new OSSClient(OssConstants.ENDPOINT,OssConstants.ACCESSKEYID,OssConstants.ACCESSKEYSECRET);
  //此处"xxxx/yyyy/"+fileName,表示上传至阿里云中xxxx文件夹下的yyyy文件夹中，请修改为自己的路径即可
  client.putObject(OssConstants.BUCKET_IMAGE_THIRD_PARTY_PIC, savePath, inputStream);
  client.shutdown();
 }

 public static void deleteImgAliyun(String imgPath)
         throws FileNotFoundException{
  OSSClient client = new OSSClient(OssConstants.ENDPOINT,OssConstants.ACCESSKEYID,OssConstants.ACCESSKEYSECRET);
  //此处"xxxx/yyyy/"+fileName,表示上传至阿里云中xxxx文件夹下的yyyy文件夹中，请修改为自己的路径即可
  client.deleteObject(OssConstants.BUCKET_IMAGE_THIRD_PARTY_PIC,imgPath);
  client.shutdown();
 }
}
