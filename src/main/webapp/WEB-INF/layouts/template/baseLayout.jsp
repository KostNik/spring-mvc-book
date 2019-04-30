<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><tiles:insertAttribute name="title"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.5/angular.min.js"></script>
    <spring:url value="/resources/js/controllers.js" var="controllersJS" />
    <script type="text/javascript" src="${controllersJS}"></script>
</head>
<body>
<section class="container">
    <div class="pull-right" style="padding-right:50px">
        <a href="?language=en">English</a>|<a
            href="?language=nl">Dutch</a>
        <a href="<c:url value="/logout"/>">Logout</a>
    </div>
</section>
<div class="container">
    <div class="jumbotron">
        <div class="header">
            <ul class="nav nav-pills pull-right">
                <tiles:insertAttribute name="navigation"/>
            </ul>
            <h3 class="text-muted">Web Store</h3>
        </div>
        <h1>
            <tiles:insertAttribute name="heading"/>
        </h1>
        <p>
            <tiles:insertAttribute name="tagline"/>
        </p>
    </div>
    <div class="row">
        <tiles:insertAttribute name="content"/>
    </div>
    <div class="footer">
        <tiles:insertAttribute name="footer"/>
    </div>
</div>
</body>
</html>
