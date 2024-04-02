package edu.eci.arep.parcial2.MathServiceServer;

import static spark.Spark.get;
import static spark.Spark.port;

import java.util.ArrayList;


/**
 * Math services server
 * 
 * @author Santiago Forero Yate
 */
public class MathServer {
    public static void main(String[] args) {
        port(getPort());
        get("/factors", (req, res) -> {
            ArrayList result = MathServices.getFactors(Integer.parseInt(req.queryParams("value")));
            String output = "";
            for(int i = 0; i < result.size()-1; i++){
                output += result.get(i) + ",";
            }
            output += result.get(result.size()-1);
            res.type("application/json");
            return "{\"operation\":\"factors\", \"input\":"+req.queryParams("value")+",\"output\": "+output+"}";
        });

        get("/primes", (req, res) -> {
            ArrayList result = MathServices.getPrimes(Integer.parseInt(req.queryParams("value")));
            String output = "";
            for(int i = 0; i < result.size()-1; i++){
                output += result.get(i) + ",";
            }
            output += result.get(result.size()-1);
            res.type("application/json");
            return "{\"operation\":\"primes\", \"input\":"+req.queryParams("value")+",\"output\": "+output+"}";
        });
    }

    private static int getPort(){
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }
}
