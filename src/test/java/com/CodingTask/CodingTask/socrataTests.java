package com.CodingTask.CodingTask;

import com.CodingTask.CodingTask.Interface.socrataService;
import com.CodingTask.CodingTask.service.socrataServiceImpl;
import org.assertj.core.api.ObjectAssert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class socrataTests {

    private socrataService _socrataService;

    public socrataTests(){
        _socrataService = new socrataServiceImpl();
    }


    @Test
    public void shouldReturn200(){
        assertThat(_socrataService.connect()).isEqualTo(200);
    }

}
