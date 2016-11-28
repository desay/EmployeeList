package com.bsu.dao;

import com.bsu.entity.Employee;

import java.util.List;

/**
 * Created by Helga on 20/05/2016.
 */
public interface EmployeeDAO {
    int createEmployee(Employee employee);
    Employee modifyEmployee(Employee employee);
    void deleteEmployee(int id);
    List getAllEmployee();
    List<Employee> sortByName();
    List<Employee> sortBySurname();
    Employee getEmployee(int id);
    List<Employee> findEmployee(String request);
}
