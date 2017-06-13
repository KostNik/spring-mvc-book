<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
            <h1>Products</h1>
            <p>All the available products in stock</p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 20px">
                <div class="thumbnail">
                    <img src="<c:url value="/img/${product.productId}.png"/>" alt="image" style="width: 100%"/>
                    <div class="caption">
                        <h3>${product.name}</h3>
                        <p>${product.description}</p>
                        <p>${product.unitPrice} USD</p>
                        <p>Available ${product.unitsInStock} units in stock</p>
                        <p>
                            <a href="<spring:url value="/market/product?id=${product.productId}"/>"
                               class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/>
                                Details
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="col-sm-6 col-md-3">
        <a href="<spring:url value="/market/products/add" />"
           class="btn btn-warning btn-large">
            <span class="glyphicon-shopping-cart glyphicon"></span>
            Add new
        </a>
    </div>
</section>


</body>
</html>
