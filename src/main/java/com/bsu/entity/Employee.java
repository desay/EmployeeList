package com.bsu.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Helga on 20/05/2016.
 */

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    private static long serialVersionUID = 123456789L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "description", nullable = false)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name="createDate", updatable = false)
    private Date addDate = new Date();

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", description='" + description + '\'' +
                ", addDate=" + addDate +
                '}');
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Employee employee = (Employee) obj;

        if (id != employee.id) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (surname != null ? !surname.equals(employee.surname) : employee.surname != null) return false;
        if (position != null ? !position.equals(employee.position) : employee.position != null) return false;
        if (department != null ? !department.equals(employee.department) : employee.department != null) return false;
        if (description != null ? !description.equals(employee.description) : employee.description != null)
            return false;
        return !(addDate != null ? !addDate.equals(employee.addDate) : employee.addDate != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        if (name != null) {
        result = 31 * result + name.hashCode(); }
        if (surname != null) {
        result = 31 * result + surname.hashCode(); }
        if (position != null) {
            result = 31 * result + position.hashCode(); }
        if (department != null) {
            result = 31 * result + department.hashCode(); }
        if (description != null) {
        result = 31 * result + description.hashCode(); }
        result = 31 * result + (addDate != null ? addDate.hashCode() : 0);
        return result;
    }
}
