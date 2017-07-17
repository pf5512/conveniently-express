package com.neng.utils.MongoDb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhubuqing on 2017/7/16.
 */
public class MongoDbUtils {
    public boolean insertDocument(Document document) {
        // 连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);

        // 连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("Demo");
        System.out.println("Connect to database successfully");

        MongoCollection<Document> collection = mongoDatabase.getCollection("location");
        System.out.println("Select location successfully");

        List<Document> documents = new ArrayList<Document>();
        documents.add(document);
        collection.insertMany(documents);
        System.out.println("Insert document successfully");
        return true;
    }


}
