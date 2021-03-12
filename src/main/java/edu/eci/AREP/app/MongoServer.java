package edu.eci.AREP.app;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * This class return all the collections in de BD
 */
public  class MongoServer {
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> coll;
    public  MongoServer(){
        mongoClient = new MongoClient("54.144.138.131", 50000);
        database = mongoClient.getDatabase("baseData");
        coll = database.getCollection("cadenas");

    }
    public ArrayList<Document>  getBaseData(){
        FindIterable<Document> finder = coll.find();
        System.out.println("Estoy en la clase MongoServer");
        System.out.println(finder);
        Iterator it = finder.iterator();
        ArrayList<Document> docs = new ArrayList<Document>();
        while (it.hasNext()) {
            docs.add((Document) it.next());
        }
        return docs;
    }






}
