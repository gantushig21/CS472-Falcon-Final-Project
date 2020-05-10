<%--
  Created by IntelliJ IDEA.
  User: gantushig
  Date: 5/10/20
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../fragments/header.jsp">
    <c:param name="title" value="Home Page" />
</c:import>

<div id="headerwrap">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <h3>Show your work with this beautiful theme</h3>
                <h1>Eyecatching Bootstrap Template.</h1>
                <h5>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</h5>
                <h5>More Lorem Ipsum added here too.</h5>
            </div>
            <div class="col-lg-8 col-lg-offset-2 himg">
                <img src="img/browser.png" class="img-responsive">
            </div>
        </div>
    </div>
</div>

<c:import url="../fragments/footer.jsp" />
