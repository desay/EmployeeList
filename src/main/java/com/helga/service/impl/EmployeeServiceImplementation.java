package com.helga.service.impl;

import com.helga.dao.EmployeeDAO;
import com.helga.entity.Employee;
import com.helga.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Helga on 20/05/2016.
 */

@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService {
    public EmployeeServiceImplementation() {
        System.out.println("in EmployeeServiceImplementation");
    }

    @Autowired
    private EmployeeDAO employeeDao;

    @Override
    public int createEmployee(Employee employee) {
        return employeeDao.createEmployee(employee);
    }

    @Override
    public Employee modifyEmployee(Employee employee) {
        return employeeDao.modifyEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Override
    public List<Employee> sortByName() {
        return employeeDao.sortByName();
    }

    @Override
    public List<Employee> sortBySurname() {
        return employeeDao.sortBySurname();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }

    @Override
    public List<Employee> findEmployees(String request) {
        return employeeDao.findEmployee(request);
    }
}
