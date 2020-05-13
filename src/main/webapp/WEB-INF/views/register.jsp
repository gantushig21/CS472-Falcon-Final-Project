<%--
  Created by IntelliJ IDEA.
  User: O.Ankhtuya
  Date: 5/10/20
  Time: 4:48 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../fragments/header.jsp">
    <c:param name="title" value="Registration"/>
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
        <div style="width: 100%; max-width: 500px;">
            <h4>Register</h4>
            <div class="hline" style="margin-bottom: 20px;"></div>
            <div class="error-message">${requestScope.get("errMsg")}</div>
            <div class="msg">${requestScope.get("msg")}</div>
            <c:if test="${requestScope.get('msg')==null}">
                <form class="contact-form" role="form" action="register" method="POST">
                    <div class="form-group">
                        <input type="text" name="firstName" class="form-control" id="firstName" placeholder="First Name"
                               required pattern=".{3,}" value="<%= (request.getParameter("firstName")==null?"":request.getParameter("firstName"))%>">
                        <div class="validate"></div>
                    </div>
                    <div class="form-group">
                        <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Last Name"
                               required pattern=".{3,}" value="<%= (request.getParameter("lastName")==null?"":request.getParameter("lastName"))%>">
                        <div class="validate"></div>
                    </div>
                    <div class="form-group">
                        <input type="email" name="email" class="form-control" id="email" placeholder="Email" required
                               pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" value="<%= (request.getParameter("email")==null?"":request.getParameter("email"))%>">
                        <div class="validate"></div>
                    </div>
                    <div class="form-group">
                        <input type="text" name="username" class="form-control" id="username" placeholder="User Name"
                               required pattern=".{4,}" title="Eight or more characters" value="<%= (request.getParameter("username")==null?"":request.getParameter("username"))%>">
                        <div class="validate"></div>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" id="password" placeholder="Password"
                               required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                               title="Must contain at least one  number and one uppercase and lowercase letter, and at least 8 or more characters">
                        <div class="validate"></div>
                    </div>
                    <div class="form-group">
                        <input type="text" name="phone" class="form-control" id="phone"  placeholder="Phone e.g. 515-717-1315 "
                               required pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" value="<%= (request.getParameter("phone")==null?"":request.getParameter("phone"))%>">
                        <div class="validate"></div>
                    </div>
                    <div class="form-group">
                        <label>Gender</label><br/>
                        <div class="job-form-check">
                            <div class="job-radio-btn">
                                <input class="form-check-input" type="radio" name="gender" id="male" required
                                       value="Male" <%= (request.getParameter("gender")!=null && request.getParameter("gender").equals("Male")?"checked":"")%> >
                                <label clas s="form-check-label">Male</label>

                            </div>
                            <div class="job-radio-btn">
                                <div class="job-radio-btn">

                                    <input class="form-check-input" type="radio" name="gender" id="female" required
                                           value="Female" <%= (request.getParameter("gender")!=null && request.getParameter("gender").equals("Female")?"checked":"")%> >
                                    <label class="form-check-label">Female</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-send">
                        <button type="submit" class="btn btn-large">Save</button>
                    </div>

                </form>
            </c:if>
            <br/><br/>
        </div>

    </div>
</div>

<c:import url="../fragments/footer.jsp"/>
