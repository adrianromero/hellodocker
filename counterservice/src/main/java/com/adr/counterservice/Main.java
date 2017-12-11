package com.adr.counterservice;

import com.zaxxer.hikari.HikariDataSource;
import java.net.InetAddress;
import org.springframework.jdbc.core.JdbcTemplate;
import spark.Spark;

public class Main {
    public static void main(String[] args) {
        
        HikariDataSource source = new HikariDataSource();
        source.setDriverClassName(System.getenv("DB_DRIVER"));
        source.setJdbcUrl(System.getenv("DB_URL"));
        source.setUsername(System.getenv("DB_USERNAME"));
        source.setPassword(System.getenv("DB_PASSWORD"));
        
        JdbcTemplate jdbc = new JdbcTemplate(source);

        // http://localhost:4567/counter
        Spark.get("/counter", (request, response) -> String.format(
                "Host: %s. Sequence: %s.\n", 
                InetAddress.getLocalHost().getHostName(),
                jdbc.queryForObject("select nextval('mysequence');", Integer.class)));
    }
}
