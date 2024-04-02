package edu.eci.arep.parcial2.proxyServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Caller {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String[] GET_URLs = {"http://ec2-54-167-174-75.compute-1.amazonaws.com:4568/", "http://ec2-18-212-8-200.compute-1.amazonaws.com:4568/"};
    private static int instancia = 1;

    public static String callMethod(String method, int n) throws IOException {

        URL obj =  (method.equals("factors")) ? new URL(GET_URLs[instancia] +method + "?value="+n) : ((method.equals("primes")) ? new URL(GET_URLs[instancia] +method + "?value="+n) : null);

        System.out.println("instancia: "+instancia + ", url: " + obj.getPath());
        if(obj.equals(null)){

            System.out.println("no se puede leer la url");
            // return "Not such Method";
        }

        changeInstance();
       

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            System.out.println("GET DONE");

            return response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        return null;

    }

    private static void changeInstance(){
        instancia = (instancia + 1) % GET_URLs.length;
    }
}
