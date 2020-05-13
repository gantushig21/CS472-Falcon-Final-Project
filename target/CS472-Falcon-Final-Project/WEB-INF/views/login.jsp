<%--
  Created by IntelliJ IDEA.
  User: O.Ankhtuya
  Date: 5/10/20
  Time: 4:48 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../fragments/header.jsp">
    <c:param name="title" value="Login Page"/>
</c:import>

<!-- *****************************************************************************************************************
BLUE WRAP
***************************************************************************************************************** -->
<div id="blue">
    <div class="container">
        <div class="row">
            <h3></h3>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /blue -->
<!-- *****************************************************************************************************************
LOGIN FORMS
***************************************************************************************************************** -->

<div class="container mtb">
    <div style="display: flex; align-items: center; justify-content: center;">
        <div style="width: 100%; max-width: 350px;">
            <h4>Login</h4>
            <div class="hline" style="margin-bottom: 20px;"></div>
            <div class="error-msg">
                <%= (request.getAttribute("errMsg")==null?"":request.getAttribute("errMsg"))%>
            </div>
            <form class="contact-form" role="form" action="login" method="POST" >
                <div class="form-group">
                    <input type="name" name="username" class="form-control" id="username" placeholder="username"
                           required>
                    <div class="validate"></div>
                </div>
                <div class="form-group ">
                    <input type="password" name="password" class="form-control" id="password" placeholder="password"
                           required>
                    <div class="validate"></div>
                </div>
                <div class="form-send">
                    <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
                    <br/>
                    <a href="register">Don't have an account. Create one now.</a>
                </div>
            </form>
            <br/><br/>
        </div>
    </div>
</div>

<c:import url="../fragments/footer.jsp"/>
