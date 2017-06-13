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
            <h1>Product</h1>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <img src="<c:url value="/img/${product.productId}.png"/>" alt="image" style="width: 100%"/>
        </div>
        <div class="col-sm-6 col-md-5" >
            <div class="caption">
                <h3>${product.name}</h3>
                <p>${product.description}</p>
                <p>
                    <strong>Item Code: </strong>
                    <span class="label label warning">${product.productId}</span>
                </p>
                <p>
                    <strong>manufacturer</strong>: ${product.manufacturer}
                </p>
                <p>
                    <strong>category</strong>: ${product.category}
                </p>
                <p>
                    <strong>Available units in stock</strong>: ${product.unitsInStock}
                </p>
                <h4>${product.unitPrice} USD</h4>
                <p>
                    <a href="#" class="btn btn-warning btn-large">
                        <span class="glyphicon-shopping-cart glyphicon"></span>
                        Order NOW
                    </a>
                    <a href="<spring:url value="/market/products" />"
                       class="btn-default">
                        <span class="glyphicon-hand-left glyphicon"></span>
                        back
                    </a>
                </p>
            </div>
        </div>
    </div>
</section>
</body>
</html>
