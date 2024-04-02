package edu.eci.arep.parcial2.proxyServer;

import spark.Spark;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;


/**
 * Proxy Server 
 *
 * @author Santiago Forero Yate
 */
public class Proxy {
    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        get("/factors", (req, res) -> {
            
            return Caller.callMethod("factors", Integer.parseInt(req.queryParams("value")));
        });
        get("/primes", (req, res) -> {
            return Caller.callMethod("primes", Integer.parseInt(req.queryParams("value")));
        });
    }

    private static int getPort(){
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
