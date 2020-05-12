<%--
  Created by IntelliJ IDEA.
  User: gantushig
  Date: 5/11/20
  Time: 7:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../fragments/header.jsp">
    <c:param name="title" value="Find a Job" />
</c:import>

<div class="search-background">

<div class="container mtb" style="padding-bottom: 80px; margin-top: 70px; margin-bottom: 0;">
    <div class="search-job-container">
        <div style="width: 100%;">
            <h2 style="margin-bottom: 30px;">Make your dreams a Reality</h2>
            <form action="jobs" method="get">
                <input type="hidden" name="action" value="list">
                <input type="hidden" name="page" value="1">
                <input type="hidden" name="limit" value="5">
                <div class="row">
                    <div class="col-md-5">
                        <div class="form-group">
                            <input type="text" class="form-control" name="q" placeholder="Job title, skills or company">
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="form-group">
                            <input type="text" class="form-control" name="location" placeholder="City or state">
                        </div>
                    </div>
                    <div class="col-md-2">
                        <div class="form-send">
                            <button type="submit" class="btn btn-large btn-theme" style="margin-top: 0">Find Jobs</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</div>


<c:import url="../fragments/footer.jsp" />
