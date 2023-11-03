package com.itqgroup.service.impl;

import com.itqgroup.dto.TimeDto;
import com.itqgroup.service.WebService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WebServiceImpl implements WebService {

    @Override
    public TimeDto findTime() {
        return new TimeDto(LocalDateTime.now());
    }
}
