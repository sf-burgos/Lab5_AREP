package RoundRobbin.Code;

import edu.eci.AREP.app.LogService.Code.MongoServer;
import org.json.JSONObject;

import static spark.Spark.get;
import static spark.Spark.port;

public class SparkWebServer {
    public static void main(String... args){
        port(getPort());
        get("Resultados", (req,res) -> {
            MongoServer conex = new MongoServer();
            JSONObject json = new JSONObject();
            json.put("cadenas", conex.getBaseData().toString());

           // json.get("salida", conex.lastTenElements(conex.getBaseData()));
            return json;
        });
    }
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
