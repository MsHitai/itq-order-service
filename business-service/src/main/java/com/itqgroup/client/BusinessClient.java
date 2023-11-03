package com.itqgroup.client;

import com.itqgroup.dto.TimeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "business-client", url = "${web.service.url}")
public interface BusinessClient {

    @GetMapping(value = "/time")
    TimeDto findTime();
}
