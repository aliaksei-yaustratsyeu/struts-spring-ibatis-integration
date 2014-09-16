package by.example.form.employee;

import by.example.model.employee.Employee;
import org.apache.struts.action.ActionForm;

import java.util.List;

/**
 * Created by a.evstratiev on 9/1/2014.
 */
public class EmployeeForm extends ActionForm {

    List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
