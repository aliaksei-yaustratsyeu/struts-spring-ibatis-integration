package by.example.dao.employee;

import by.example.model.employee.Employee;

import java.util.List;

/**
 * Created by a.evstratiev on 9/1/2014.
 */
public interface EmployeeDao {
    public List<Employee> getEmployees();
}
