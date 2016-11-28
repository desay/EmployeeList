package com.bsu.dao.impl;

import com.bsu.dao.EmployeeDAO;
import com.bsu.entity.Employee;
import com.bsu.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Helga on 20/05/2016.
 */
@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {
    public EmployeeDAOImplementation() {
        System.out.println("in employeeDAOImplementation");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public int createEmployee(Employee employee) {
        return (int) hibernateUtil.create(employee);
    }

    @Override
    public Employee modifyEmployee(Employee employee) {
        return hibernateUtil.modify(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setDescription("toDelete");
        employee.setName("toDelete");
        employee.setDepartment("toDelete");
        employee.setSurname("toDelete");
        employee.setPosition("toDelete");
        hibernateUtil.delete(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return hibernateUtil.fetchAll(Employee.class);
    }

    @Override
    public List<Employee> sortByName()  {
        List<Employee> result = getAllEmployee();
        Collections.sort(result, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        return result;    }

    @Override
    public List<Employee> sortBySurname() {
        List<Employee> result = getAllEmployee();
        Collections.sort(result, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });

        return result;
    }

    @Override
    public Employee getEmployee(int id) {
        return hibernateUtil.fetchById(id, Employee.class);
    }

    @Override
    public List<Employee> findEmployee(String request) {
        String query = "SELECT id, description, createDate, name, surname, position, department FROM employee WHERE name LIKE '%" + request + "%'";
        List<Object[]> listEmployee = hibernateUtil.fetchAll(query);
        List<Employee> employees = new ArrayList<>();
        for (Object[] employeeObject : listEmployee) {
            Employee employee = new Employee();
            int id = (int) employeeObject[0];
            String description = (String) employeeObject[1];
            Date addDate = (Date) employeeObject[2];
            String name = (String) employeeObject[3];
            String surname = (String) employeeObject[4];
            String position = (String) employeeObject[5];
            String department = (String) employeeObject[6];
            employee.setId(id);
            employee.setDescription(description);
            employee.setAddDate(addDate);
            employee.setName(name);
            employee.setSurname(surname);
            employee.setPosition(position);
            employee.setDepartment(department);
            employees.add(employee);
        }
        return employees;
    }
}
