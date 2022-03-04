package com.CodingTask.CodingTask.controller;

import com.CodingTask.CodingTask.dto.inputRequestDto;
import com.CodingTask.CodingTask.dto.outputResponseDto;
import com.CodingTask.CodingTask.service.HydrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/home")
public class homeController {


    @Autowired
    private HydrantService hydrantService;

    public homeController() {
    }

    @GetMapping
    public ResponseEntity<outputResponseDto> calculate(@Valid @RequestBody inputRequestDto dto){
        return ResponseEntity.ok(hydrantService.getHydrants(dto));
    }
}
