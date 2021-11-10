package com.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class TestSave {


    @Bean
    CommandLineRunner commandLineRunner(Repo repo) {

        return args -> {
            DateWorkEntityGenerateCustomize a = new DateWorkEntityGenerateCustomize();
//            a.setIdDateWork(2121);
            a.setListUserHalfDay("dsfads");
            a.setListUserHalfDay("dsfsa");
            a.setRegulation(2);

            repo.save(a);
        };
    };

}
