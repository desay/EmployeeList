<%--
  Created by IntelliJ IDEA.
  User: Helga
  Date: 20/05/2016
  Time: 00:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                <div align="left"><b>Employee List</b></div>
                <div align="right"><a href="${pageContext.request.contextPath}/createEmployee">Add New Employee</a></div>
            </h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover table-bordered">
                <tr>
                    <th>
                        <form action="${pageContext.request.contextPath}/findEmployee">
                            <table>
                                <tr>
                                    <th>Search by name:</th>
                                    <th><input type='text' name='findRequest' id='findRequest'/></th>
                                    <th>
                                        <div class="col-md-4"><input class="btn btn-success" type='submit'
                                                                     value='Search'/></div>
                                    </th>
                                </tr>
                            </table>
                        </form>
                    </th>
                    <th>
                        <form action="${pageContext.request.contextPath}/">
                            <div class="row">
                                <div class="col-md-4"><input class="btn btn-success" type='submit'
                                                             value='Search all'/></div>
                            </div>
                        </form>
                    </th>
                    <th>
                        <form action="${pageContext.request.contextPath}/sortByName">
                            <div class="row">
                                <div class="col-md-4"><input class="btn btn-success" type='submit'
                                                             value='Sort by name'/></div>
                            </div>
                        </form>
                    </th>
                    <th>
                        <form action="${pageContext.request.contextPath}/sortBySurname">
                            <div class="row">
                                <div class="col-md-4"><input class="btn btn-success" type='submit'
                                                             value='Sort by surname'/></div>
                            </div>
                        </form>
                    </th>
                </tr>
            </table>
            <c:if test="${empty employeeList}">
                There are no Employee
            </c:if>
            <c:if test="${not empty employeeList}">


                <table class="table table-hover table-bordered">
                    <thead style="background-color: #dff0d8;">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Position</th>
                        <th>Department</th>
                        <th>Description</th>
                        <th>Add date</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${employeeList}" var="tas">
                        <tr>
                            <th>
                                <c:out value='${tas.id}'/>
                            </th>
                            <th>
                                <c:out value="${tas.name}"/>
                            </th>
                            <th>
                                <c:out value="${tas.surname}"/>
                            </th>
                            <th>
                                <c:out value="${tas.position}"/>
                            </th>
                            <th>
                                <c:out value="${tas.department}"/>
                            </th>
                            <th>
                                <c:out value="${tas.description}"/>
                            </th>
                            <th>
                                <c:out value="${tas.addDate}"/>
                            </th>
                            <th>
                                <a href="modifyEmployee?id=<c:out value='${tas.id}' />">Edit</a>
                            </th>
                            <th>
                                <a href="deleteEmployee?id=<c:out value='${tas.id}' />">Delete</a>
                            </th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</div>

<script type="text/javascript">
    function doneOrNotDone() {
        var tempDone = $('#isDone').val();
        if (tempDone == 1) {
            <c:out value="Done"/>
        }
        if (tempDone == 0) {
            <c:out value="Not done"/>
        }

        return true;
    }
    ;
</script>
</body>
</html>