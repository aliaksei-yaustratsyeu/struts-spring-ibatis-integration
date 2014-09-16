package by.example.action.employee;

import by.example.action.BaseAction;
import by.example.form.employee.EmployeeForm;
import by.example.model.employee.Employee;
import by.example.service.employee.EmployeeService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Employee controller/action.
 *
 * Created by a.evstratiev on 9/1/2014.
 */
@Controller
public class EmployeeAction extends BaseAction {

    @Autowired
    EmployeeService employeeService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws java.lang.Exception {

        EmployeeForm employeeForm = (EmployeeForm)form;

        List<Employee> employees = employeeService.getEmployees();

        employeeForm.setEmployees(employees);

        return mapping.findForward("list");
    }

}
