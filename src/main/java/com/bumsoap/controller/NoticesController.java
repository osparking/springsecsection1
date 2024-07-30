package com.bumsoap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping("/notices")
    public String getNotices() {
        return "이것들은 DB에서 읽어온 알림문들이다.";
    }
}

