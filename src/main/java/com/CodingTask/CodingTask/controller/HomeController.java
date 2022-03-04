package com.CodingTask.CodingTask.controller;

import com.CodingTask.CodingTask.dto.InputRequestDto;
import com.CodingTask.CodingTask.dto.OutputResponseDto;
import com.CodingTask.CodingTask.service.HydrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/home")
public class HomeController {


    @Autowired
    private HydrantService hydrantService;

    public HomeController() {
    }

    @GetMapping
    public ResponseEntity<OutputResponseDto> calculate(@Valid @RequestBody InputRequestDto dto){
            return new ResponseEntity<OutputResponseDto>(hydrantService.getHydrants(dto), HttpStatus.OK);
    }
}
