<%--
  Created by IntelliJ IDEA.
  User: O.Ankhtuya
  Date: 5/10/20
  Time: 4:48 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../fragments/header.jsp">
  <c:param name="title" value="login Page" />
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

  <div class="container">
    <div class="row">
      <div class="col-lg-offset-4">
        <h4>Login</h4>
          <div class="error-msg">
              <%= (request.getAttribute("errMsg")==null?' ':request.getAttribute("errMsg"))%>
          </div>
          <div>
              <%= (session.getAttribute("loggedUser")==null?' ':session.getAttribute("loggedUser"))%>
          </div>
        <form class="contact-form" role="form" action="login" method="POST" style="width: 350px">
            <div class="form-group">
                <input type="name" name="username" class="form-control" id="username" placeholder="username" required pattern="" >
                <div class="validate"></div>
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" id="password" placeholder="password" required pattern="">
                <div class="validate"></div>
            </div>


            <div class="form-send" >
                <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button><br/>
                <a href="register">Don't have an account. Create one now.</a>
            </div>

          </form><br/><br/>
      </div>
    <div class="container-fluid">

    </div>
    </div>
  </div>

<c:import url="../fragments/footer.jsp" />
