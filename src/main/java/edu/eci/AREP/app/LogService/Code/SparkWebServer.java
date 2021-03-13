package edu.eci.AREP.app.LogService.Code;

import org.json.JSONObject;
import static spark.Spark.*;

public class SparkWebServer {
    public static void main(String... args){

        port(getPort());
        MongoServer conex = new MongoServer();

        get("hello", (req,res) -> {

            JSONObject json = new JSONObject();
            json.put("cadenas", conex.getBaseData().toString());

           //json.put("salida", conex.lastTenElements(conex.getBaseData()));
            //json.put("nombres", conex.addData(name));
            return json;
        });

        post("hello",(req,res) ->{
            conex.addData(req.body());
            return "";
        });

    }


    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
