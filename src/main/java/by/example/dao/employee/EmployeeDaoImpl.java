package by.example.dao.employee;

import by.example.dao.BaseDao;
import by.example.model.employee.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by a.evstratiev on 9/1/2014.
 */
@Repository("employeeDao")
public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    public List<Employee> getEmployees() {
        List<Employee> employees = sqlMapClientTemplate.queryForList("getEmployees");
        return employees;
    }
}
