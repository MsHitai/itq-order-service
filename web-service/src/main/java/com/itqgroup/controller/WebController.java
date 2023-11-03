package com.itqgroup.controller;

import com.itqgroup.dto.TimeDto;
import com.itqgroup.service.WebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time")
@Slf4j
public class WebController {

    private final WebService webService;

    @Autowired
    public WebController(WebService webService) {
        this.webService = webService;
    }

    @GetMapping
    public TimeDto findTime() {
        log.info("Received GET request to fetch time");
        return webService.findTime();
    }
}
