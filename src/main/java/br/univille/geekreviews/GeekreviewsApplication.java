package br.univille.geekreviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeekreviewsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GeekreviewsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
