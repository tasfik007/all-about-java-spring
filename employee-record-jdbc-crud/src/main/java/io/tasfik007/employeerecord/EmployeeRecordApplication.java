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

        Employee employee1 = new Employee(10011L, "Captain", "America", "captain@gmail.com");
        Employee employee2 = new Employee(10012L, "Black", "Widow", "blacwidow@gmail.com");
        Employee employee3 = new Employee(10013L, "Tony", "Stark", "stark@gmail.com");

        logger.info("Inserting -> {}", employeeDao.insert(employee1));
        logger.info("Inserting -> {}", employeeDao.insert(employee2));
        logger.info("Inserting -> {}", employeeDao.insert(employee3));

        logger.info("Employee id 10011 -> {}", employeeDao.findById(10011L));

        Employee updatedEmployee = new Employee(10011L, "Sansa", "Stark", "sansa@gmail.com");
        logger.info("Update 10003 -> {}", employeeDao.update(updatedEmployee));

        logger.info("Deleting Employee id 10013 -> {}", employeeDao.deleteById(10013L));

        logger.info("All users -> {}", employeeDao.findAll());

    }
}
