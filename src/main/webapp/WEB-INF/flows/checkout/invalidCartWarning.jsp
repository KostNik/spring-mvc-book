<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring"
           uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <title>Invalid cart </title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1 class="alert alert-danger"> Empty Cart</h1>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <p>
            <a href="<spring:url value="/market/products" />"
               class="btn btn-primary">
                     <span class="glyphicon-hand-left glyphicon">
                     </span> products
            </a>
        </p>
    </div>
</section>
</body>
</html>

