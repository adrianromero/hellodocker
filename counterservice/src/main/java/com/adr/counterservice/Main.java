package com.adr.counterservice;

import java.net.InetAddress;
import spark.Spark;

public class Main {
    public static void main(String[] args) {

        // http://localhost:4567/counter
        Spark.get("/counter", (request, response) -> String.format(
                "Host: %s.\n", 
                InetAddress.getLocalHost().getHostName()));
    }
}