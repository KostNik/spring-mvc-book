<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1 class="alert alert-danger"> There is no
                product found with the Product id
                ${invalidProductId}</h1>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <p>${url}</p>
        <p>${exception}</p>
    </div>

    <div class="container">
        <p>
            <a href="<spring:url value="/market/products"/>" class="btn btn-primary">
                <span class="glyphicon-hand-left glyphicon"/>
                products
            </a>
        </p>
    </div>
</section>

