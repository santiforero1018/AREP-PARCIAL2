package edu.eci.arep.parcial2.MathServiceServer;

import java.util.ArrayList;

public class MathServices {
    public static ArrayList<Integer> getFactors(int n){

        ArrayList resp = new ArrayList<Integer>();
        resp.add(1);
        if(n == 1){
            return resp;
        } else {
            for(int i = 2; i <= n/2; i++){
                if(n % i == 0){
                    resp.add(i);
                }
            }
            resp.add(n);
        }
        return resp;
    }

    public static ArrayList<Integer> getPrimes(int n){

        ArrayList resp = new ArrayList<Integer>();

        for(int i = 2; i <= n; i++){
            if(isPrime(i)){
                resp.add(i);
            }
        }

        return resp;
    }

    private static boolean isPrime(int m){

        ArrayList rev = new ArrayList<Integer>();

        for(int i = 2; i <= m/2; i++){
            if(m % i == 0){
                rev.add(i);
            }
        }

        return rev.size() <= 2;
    }
}
