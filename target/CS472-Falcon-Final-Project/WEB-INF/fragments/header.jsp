<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>${param.title}</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">
    <link href="/img/favicon.png" rel="icon">
    <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Raleway:400,700,900|Lato:400,900" rel="stylesheet">

    <!-- Bootstrap CSS File -->
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Libraries CSS Files -->
    <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="lib/prettyphoto/css/prettyphoto.css" rel="stylesheet">
    <link href="lib/hover/hoverex-all.css" rel="stylesheet">

    <!-- Main Stylesheet File -->
    <link href="css/style.css" rel="stylesheet">

</head>
<body>

<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">JOB SEARCH</a>
        </div>


        <c:choose>
            <c:when test="${sessionScope.get('loggedUser')!=null}">
                <div class="navbar-collapse collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li><a href="home">HOME</a></li>
                        <li><a href="about">ABOUT</a></li>
                        <li><a href="search">SEARCH</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Welcome ${sessionScope.get('loggedUser').firstName} ${sessionScope.get('loggedUser').lastName}
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="logout">LOGOUT</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </c:when>
            <c:otherwise>
                <div class="navbar-collapse collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li><a href="home">HOME</a></li>
                        <li><a href="about">ABOUT</a></li>
                        <li><a href="search">SEARCH</a></li>
                        <li><a href="login">LOGIN</a></li>
                    </ul>
                </div>
            </c:otherwise>
        </c:choose>

    </div>
</div>