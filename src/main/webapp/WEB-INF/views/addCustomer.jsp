<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Welcome</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Customers</h1>
            <p>Add customers</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form method="post" modelAttribute="newCustomer" class="form-horizintal">
        <fieldset>
            <legend>Add new customer</legend>
            <form>
                <div class="form-group">
                    <label for="customerId">Customer ID</label>
                    <form:input id="customerId" path="customerId"
                                type="text" class="form:input-large"/>
                </div>
                <div class="form-group">
                    <label for="name">Name</label>
                    <form:input id="name" path="name"
                                type="text" class="form:input-large"/>
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <form:input id="address" path="address"
                                type="text" class="form:input-large"/>
                </div>
                <%--<div class="form-group">--%>
                    <%--<label class="control-label col-lg-2 col-lg-2"--%>
                           <%--for="noOfOrdersMade">NoOfOrdersMade</label>--%>
                    <%--<div class="col-lg-10">--%>
                        <%--<form:input id="noOfOrdersMade" path="noOfOrdersMade"--%>
                                    <%--type="text" class="form:input-large"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <div class="col-lg-offset-2 col-lg-10">
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </form>
        </fieldset>

    </form:form>
</section>
</body>
</html>
