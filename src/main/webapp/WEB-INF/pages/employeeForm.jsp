<%--
  Created by IntelliJ IDEA.
  User: Helga
  Date: 20/05/2016
  Time: 01:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Vasyl Malik">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee info</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container{
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <div align="left"><b>Employee Description</b></div>
            <div align="right"><a href="${pageContext.request.contextPath}/">Home</a></div>

        </div>
        <form:form id="employeeAddForm" class="form-horizontal" style="margin-top: 20px;"
                   modelAttribute="employee" method="post" action="saveEmployee">

            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">Name</label>
                <div class="col-sm-6">
                    <form:hidden path="id" value="${employeeObject.id}"/>
                    <form:input cssClass="form-control" path="name" value="${employeeObject.name}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="surname" class="col-sm-2 control-label">Surname</label>
                <div class="col-sm-6">
                    <form:hidden path="id" value="${employeeObject.id}"/>
                    <form:input cssClass="form-control" path="surname" value="${employeeObject.surname}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="position" class="col-sm-2 control-label">Position</label>
                <div class="col-sm-6">
                    <form:hidden path="id" value="${employeeObject.id}"/>
                    <form:input cssClass="form-control" path="position"  value="${employeeObject.position}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="department" class="col-sm-2 control-label">Department</label>
                <div class="col-sm-6">
                    <form:hidden path="id" value="${employeeObject.id}"/>
                    <form:input cssClass="form-control" path="department" value="${employeeObject.department}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">Description</label>
                <div class="col-sm-6">
                    <form:hidden path="id" value="${employeeObject.id}"/>
                    <form:input cssClass="form-control" path="description" value="${employeeObject.description}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" id="saveEmployee" class="btn btn-primary" value="Save" onclick="return submitEmployeeForm();"/>
                </div>
            </div>
        </form:form>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


</body>
</html>