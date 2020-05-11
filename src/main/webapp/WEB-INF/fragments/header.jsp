<%--
  Created by IntelliJ IDEA.
  User: gantushig
  Date: 5/10/20
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta charset="utf-8">
    <title>${param.title}</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">
    <link href="${pageContext.request.contextPath}/img/favicon.png" rel="icon">
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
            <a class="navbar-brand" href="index.html">SOLID.</a>
        </div>
        <div class="navbar-collapse collapse navbar-right">
            <ul class="nav navbar-nav">
                <li><a href="index.html">HOME</a></li>
                <li><a href="about.html">ABOUT</a></li>
                <li><a href="contact.html">CONTACT</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">PAGES <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="blog.html">BLOG</a></li>
                        <li><a href="single-post.html">SINGLE POST</a></li>
                        <li><a href="portfolio.html">PORTFOLIO</a></li>
                        <li><a href="single-project.html">SINGLE PROJECT</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>