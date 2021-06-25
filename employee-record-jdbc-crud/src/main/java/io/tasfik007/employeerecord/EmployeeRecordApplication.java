package io.tasfik007.employeerecord;

import io.tasfik007.employeerecord.dao.EmployeeDao;
import io.tasfik007.employeerecord.model.Employee;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;

@SpringBootApplication
public class EmployeeRecordApplication implements CommandLineRunner {

    private final EmployeeDao employeeDao;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public EmployeeRecordApplication(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeRecordApplication.class, args);
    }

    @Override
    public void run(String... args) {

        //some initial dummy data inserted via resources/data.sql

        Employee employee = new Employee(
                10014L,
                "Tasfik",
                "Rahman",
                "tasfik@mail.com"
        );
        logger.info("Inserting -> {}", employeeDao.insert(employee));

        logger.info("Employee id 10011 -> {}", employeeDao.findById(10011L));

        Employee updatedEmployee = new Employee(
                10011L,
                "Sansa",
                "Stark", 
                "sansa@mail.com"
        );
        logger.info("Update 10011 -> {}", employeeDao.update(updatedEmployee));

        logger.info("Deleting Employee id 10013 -> {}", employeeDao.deleteById(10013L));
        logger.info("All users -> {}", employeeDao.findAll());

    }
}
