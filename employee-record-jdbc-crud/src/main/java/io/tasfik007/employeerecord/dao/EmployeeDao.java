package io.tasfik007.employeerecord.dao;

import io.tasfik007.employeerecord.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class EmployeeDao {
    JdbcTemplate jdbcTemplate;

    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Employee> employeeRowMapper = (ResultSet rs, int rowNum) -> {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setEmail(rs.getString("email_address"));
            return employee;
    };

    public List< Employee > findAll() {
        String query = "select * from employees";
        return jdbcTemplate.query(query, employeeRowMapper);
    }
    public Employee findById(long id) {
        String query = "select * from employees where id=?";
        return jdbcTemplate.queryForObject(query, employeeRowMapper,id);
    }
    public int deleteById(long id) {
        String query = "delete from employees where id=?";
        return jdbcTemplate.update(query, id);
    }
    public int insert(Employee employee) {
        String query = "insert into employees (id, first_name, last_name, email_address) values(?, ?, ?, ?)";
        return jdbcTemplate.update( query,
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getEmail());
    }
    public int update(Employee employee) {
        String query = "update employees " + " set first_name = ?, last_name = ?, email_address = ? " + " where id = ?";
        return jdbcTemplate.update(query,
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getEmail(),
                        employee.getId());
    }

}
