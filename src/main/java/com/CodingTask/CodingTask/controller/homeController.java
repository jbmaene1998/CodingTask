package com.CodingTask.CodingTask.controller;

import com.CodingTask.CodingTask.Interface.socrataService;
import com.CodingTask.CodingTask.dto.hydrantsToFireResponseDto;
import com.CodingTask.CodingTask.dto.inputRequestDto;
import com.CodingTask.CodingTask.dto.outputResponseDto;
import com.CodingTask.CodingTask.entity.firehose;
import com.CodingTask.CodingTask.service.socrataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/home")
public class homeController {

    private socrataServiceImpl socrataService = new socrataServiceImpl();

    @GetMapping
    public outputResponseDto calculate(@RequestBody inputRequestDto dto){
        return socrataService.getResults(dto.getFireLongitude(), dto.getFireLatitude(), dto.getNumberOfFiretrucks());
    }
}
