package com.helga.controller;

import com.helga.entity.Employee;
import com.helga.service.EmployeeService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Helga on 20/05/2016.
 */
@Controller
public class EmployeeController {
    private final static Logger logger = Logger.getLogger(EmployeeController.class);

    public EmployeeController() {
        System.out.println("in EmployeeController");
    }

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("createEmployee")
    public ModelAndView createEmployee (@ModelAttribute Employee employee) {
        logger.info("Creating Employee. Data = " + employee);
        return new ModelAndView("employeeForm");
    }

    @RequestMapping("modifyEmployee")
    public ModelAndView modifyEmployee(@RequestParam int id, @ModelAttribute Employee employee) {
        logger.info("Modifying Employee. Id = " + employee);
        employee = employeeService.getEmployee(id);
        return new ModelAndView("employeeForm", "employeeObject", employee);
    }

    @RequestMapping("saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
        logger.info("Saving Employee. Data = " + employee);
        if (employee.getId() == 0) {
            employeeService.createEmployee(employee);
        } else {
            employeeService.modifyEmployee(employee);
        }
        return new ModelAndView("redirect:getAllEmployee");
    }

    @RequestMapping("deleteEmployee")
    public ModelAndView deleteEmployee(@RequestParam int id) {
        logger.info("Deleting Employee. Id = " + id);
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:getAllEmployee");
    }

    @RequestMapping(value = {"getAllEmployee", "/"})
    public ModelAndView getAllEmployee() {
        logger.info("Getting all employees");
        List<Employee> employeeList = employeeService.getAllEmployee();
        return new ModelAndView("employeeList", "employeeList", employeeList);
    }

    @RequestMapping(value = {"sortByName", "/sortByName"})
    public ModelAndView sortByName() {
        logger.info("Getting all done employees");
        List<Employee> employeeList = employeeService.sortByName();
        return new ModelAndView("employeeList", "employeeList", employeeList);
    }

    @RequestMapping(value = {"sortBySurname", "/sortBySurname"})
    public ModelAndView sortBySurname() {
        logger.info("Getting all not done employees");
        List<Employee> employeeList = employeeService.sortBySurname();
        return new ModelAndView("employeeList", "employeeList", employeeList);
    }

    @RequestMapping("findEmployee")
    public ModelAndView findEmployee(@RequestParam("findRequest") String findRequest) {
        logger.info("Finding employees by name using Data = " + findRequest);
        List<Employee> employeeList = employeeService.findEmployees(findRequest);
        return new ModelAndView("employeeList", "employeeList", employeeList);
    }
}