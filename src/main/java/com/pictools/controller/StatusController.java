package com.pictools.controller;

import com.pictools.model.Status;
import com.pictools.repository.IStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/status")
public class StatusController {
    private final static Logger LOGGER = LoggerFactory.getLogger(StatusController.class);

    @Autowired
    private IStatusRepository statusRepository;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Status status) {
        LOGGER.info("POST /status body {}", status);
        return new ResponseEntity<>(statusRepository.save(status), OK);
    }
}
