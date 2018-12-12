package com.pictools;

import com.pictools.model.Status;
import com.pictools.repository.IStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Application implements CommandLineRunner {
    private Logger LOGGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private IStatusRepository statusRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        Status status = new Status();
        status.setName("CREATED");
        statusRepository.save(status);
        LOGGGER.info("Status count {}", statusRepository.count());
    }
}