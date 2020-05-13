<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>${param.title}</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">
    <link href="${pageContext.request.contextPath}/img/falcon.png" rel="icon">
    <link href="${pageContext.request.contextPath}/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Raleway:400,700,900|Lato:400,900" rel="stylesheet">

    <!-- Bootstrap CSS File -->
    <link href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Libraries CSS Files -->
    <link href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/lib/prettyphoto/css/prettyphoto.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/lib/hover/hoverex-all.css" rel="stylesheet">

    <!-- Main Stylesheet File -->
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/add-job.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/search-job.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/job.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/job-modal.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/lib/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/php-mail-form/validate.js"></script>
    <script src="${pageContext.request.contextPath}/lib/prettyphoto/js/prettyphoto.js"></script>
    <script src="${pageContext.request.contextPath}/lib/isotope/isotope.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/hover/hoverdir.js"></script>
    <script src="${pageContext.request.contextPath}/lib/hover/hoverex.min.js"></script>
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
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">JOB SEARCH</a>
        </div>


        <c:choose>
            <c:when test="${sessionScope.get('loggedUser')!=null}">
                <div class="navbar-collapse collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/home">HOME</a></li>
                        <li><a href="${pageContext.request.contextPath}/about">ABOUT</a></li>
                        <li><a href="${pageContext.request.contextPath}/posts">POST JOB</a></li>
                        <li>
                            <a href="${pageContext.request.contextPath}/logout">Welcome ${sessionScope.get('loggedUser').firstName},
                                LOGOUT</a>
                        </li>
                    </ul>
                </div>
            </c:when>
            <c:otherwise>
                <div class="navbar-collapse collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/home">HOME</a></li>
                        <li><a href="${pageContext.request.contextPath}/about">ABOUT</a></li>
                        <li><a href="${pageContext.request.contextPath}/posts">POST JOB</a></li>
                        <li><a href="${pageContext.request.contextPath}/login">LOGIN</a></li>
                    </ul>
                </div>
            </c:otherwise>
        </c:choose>

    </div>
</div>