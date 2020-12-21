package com.example.valiantlytix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ValiantlytixApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ValiantlytixApplication.class, args);
    }

}
