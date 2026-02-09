package com.rfid.rfid_client_scanner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rfid")
public class HeathCheck {


    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "RFID Bridge application is up and running!";
    }
}
