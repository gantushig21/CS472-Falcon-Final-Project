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
      <div style="display: flex; justify-content: center; align-items: center;">
          <div>
            <h3>Register</h3>
              <div class="error-msg">
                  <%= (request.getAttribute("errMsg")==null?' ':request.getAttribute("errMsg"))%>
              </div>
            <form class="contact-form" role="form" action="register" method="POST" style="width: 500px">
                <div class="form-group">
                    <input type="text" name="firstName" class="form-control" id="firstName" placeholder="FirstName" required >
                    <div class="validate"></div>
                </div>
                <div class="form-group">
                    <input type="text" name="lastName" class="form-control" id="lastName" placeholder="LastName" required>
                    <div class="validate"></div>
                </div>
                <div class="form-group">
                    <input type="email" name="email" class="form-control" id="email" placeholder="Email" required>
                    <div class="validate"></div>
                </div>
                <div class="form-group">
                    <input type="text" name="username" class="form-control" id="username" placeholder="Username" required>
                  <div class="validate"></div>
                </div>
                <div class="form-group">
                  <input type="password" name="password" class="form-control" id="password" placeholder="Password" required>
                  <div class="validate"></div>
                </div>
                <div class="form-group">
                    <input type="text" name="phone" class="form-control" id="phone" placeholder="Phone Number" required>
                    <div class="validate"></div>
                </div>
                <div class="form-group">
                    <label>*Gender</label><br/>
                    <div class="form-check form-check-inline">
                        <input required class="form-check-input" type="radio" name="gender" id="male" value="Male" <%= (request.getParameter("gender")!=null && request.getParameter("gender").equals("Male")?"checked":"")%> >
                        <label class="form-check-label" > Male</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input required class="form-check-input" type="radio" name="gender" id="female" value="Female" <%= (request.getParameter("gender")!=null && request.getParameter("gender").equals("Female")?"checked":"")%> >
                        <label class="form-check-label" > Female</label>
                    </div>
                </div>


                <div class="loading"></div>
                <div class="error-message"></div>
                <div class="sent-message"></div>

                <div class="form-send">
                  <button type="submit" class="btn btn-large">Save</button>
                </div>

              </form><br/><br/>
      </div>
    </div>
  </div>

<c:import url="../fragments/footer.jsp" />
