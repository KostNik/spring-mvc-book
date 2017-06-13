<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>

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
    <div class="pull-tight" style="padding-right: 50px">
        <h5>Select Language</h5>
        <p>
            <a href="?language=en">English</a>|
            <a href="?language=nl">Dutch</a>|
            <a href="?language=ua">Украiнська</a>
        </p>
        <a href="<c:url value="/logout" />">Logout</a>
    </div>
</section>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Products</h1>
            <p>Add products</p>
        </div>
    </div>
</section>

<section class="container">
    <form:form method="post" modelAttribute="newProduct" class="form-horizintal" enctype="multipart/form-data">
        <fieldset>
            <legend>Add new product</legend>
            <div class="form-group">
                <label class="control-label col-lg-2"
                       for="productId"><spring:message code="addProduct.form.prodId.label"/></label>
                <div class="col-lg-10">
                    <form:input id="productId" path="productId"
                                type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-sm-6"
                       for="name"><spring:message code="addProduct.form.name.label"/></label>
                <div class="col-lg-10">
                    <form:input id="name" path="name"
                                type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-sm-6"
                       for="manufacturer"><spring:message code="addProduct.form.manufacturer.label"/></label>
                <div class="col-lg-10">
                    <form:input id="manufacturer" path="manufacturer"
                                type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-sm-6"
                       for="category"><spring:message code="addProduct.form.category.label"/></label>
                <div class="col-lg-10">
                    <form:input id="category" path="category"
                                type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-sm-6"
                       for="unitsInStock"><spring:message code="addProduct.form.unitsInStock.label"/></label>
                <div class="col-lg-10">
                    <form:input id="unitsInStock" path="unitsInStock"
                                type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-sm-6"
                       for="unitPrice"><spring:message code="addProduct.form.unitPrice.label"/></label>
                <div class="col-lg-10">
                    <form:input id="unitPrice" path="unitPrice"
                                type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2 col-sm-6"
                       for="description"><spring:message code="addProduct.form.description.label"/></label></label>
                <div class="col-lg-10">
                    <form:textarea id="description"
                                   path="description" rows="2"/>
                </div>
            </div>
            <div class="form-group">
                    <%--@declare id="condition"--%>
                <label class="control-label col-lg-2 col-sm-6"
                       for="condition"><spring:message code="addProduct.form.condition.label"/></label>
                <div class="col-lg-10">
                    <form:radiobutton path="condition"
                                      value="New"/>New
                    <form:radiobutton path="condition"
                                      value="Old"/>Old
                    <form:radiobutton path="condition"
                                      value="Refurbished"/>Refurbished
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-3" for="productImage">
                    <spring:message code="addProduct.form.prodImage.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productImage" path="productImage" type="file" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-3" for="productImage">
                    <spring:message code="addProduct.form.productManual.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productImage" path="productManual" type="file" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn
                         btn-primary" value="Add"/>
                </div>
            </div>
        </fieldset>

    </form:form>
</section>
</body>
</html>
