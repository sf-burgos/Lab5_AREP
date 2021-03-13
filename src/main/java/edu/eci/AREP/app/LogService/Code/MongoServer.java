package edu.eci.AREP.app.LogService.Code;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
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
        //System.out.println("Estoy en la clase MongoServer");
        //System.out.println(finder);
        Iterator it = finder.iterator();
        ArrayList<Document> docs = new ArrayList<Document>();
        while (it.hasNext()) {
            System.out.println(it.next());
            docs.add((Document) it.next());
        }

        return docs;
    }

    public JSONObject lastTenElements(ArrayList<Document> lista){
        JSONObject obj = new JSONObject();
        int ik = 0;
        for (int i=lista.size()-1;i>=0 && ik<9; i--){
            obj.append("Los ultimos 10 datos del JSON",lista.get(i));
        }
        return obj;

    }
    public void setBaseData(){
        ArrayList<Document> setBaseData = getBaseData();


    }

    public void addData(String cadena){
        JSONObject json = new JSONObject(cadena);
        Document document=new Document();
        document.put("nombres",json.get("nombres"));
        coll.insertOne(document);

        }

    private String getDate(){
        java.util.Date fecha = new Date();
        return (fecha.toString());
    }

}
