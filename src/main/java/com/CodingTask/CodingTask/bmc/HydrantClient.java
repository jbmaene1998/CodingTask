package com.CodingTask.CodingTask.bmc;

import com.CodingTask.CodingTask.dto.HydrantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "Jesus", url = "https://data.cityofnewyork.us",path = "/resource")
public interface HydrantClient {
    @GetMapping("/5bgh-vtsn.json")
    List<HydrantDto> getHydrants(@RequestParam String $select,
                                 @RequestParam String $where,
                                 @RequestParam String $order,
                                 @RequestParam String $limit
    );
}
