package com.cognizant.truyumrestapi;

import com.cognizant.truyumrestapi.dao.EmployeeRepository;
import com.cognizant.truyumrestapi.entity.Employee;
import com.cognizant.truyumrestapi.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class TruyumRestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TruyumRestapiApplication.class, args);
    }
}
