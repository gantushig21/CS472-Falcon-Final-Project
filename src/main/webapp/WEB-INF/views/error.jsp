<%--
  Created by IntelliJ IDEA.
  User: gantushig
  Date: 5/10/20
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../fragments/header.jsp">
    <c:param name="title" value="Error Page" />
</c:import>

<div class="container mtb">
    <div class="row">
        <div class="col-lg-6">
            <h1>Something went wrong!</h1>
        </div>
    </div>
</div>

<c:import url="../fragments/footer.jsp" />