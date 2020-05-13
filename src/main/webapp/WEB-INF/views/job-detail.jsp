<%--
  Created by IntelliJ IDEA.
  User: gantushig
  Date: 5/11/20
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../fragments/header.jsp">
    <c:param name="title" value="Job details" />
</c:import>

<div class="container mtb">
    <c:if test="${not empty job}">
        <div class="row">
            <div class="col-lg-8">
                <div class="spacing"></div>
                <h4>Job Description</h4>
                <p>${job.description}</p>
            </div>

            <div class="col-lg-4">
                <div class="spacing"></div>
                <h4>Information</h4>
                <div class="hline"></div>
                <p><b>Posted:</b> <fmt:formatDate value="${job.postDate}" type="date"/></p>
                <p><b>Company Name:</b> ${job.company}</p>
                <p><b>Position:</b> ${job.title}</p>
                <p><b>Status:</b> ${job.status}</p>
                <p><b>Skills:</b> ${job.skills}</p>
             <!--   <p><b>Website:</b> <a href="http://example.com">http://example.com</a></p> -->
                <div class="spacing"></div>
                <h4>Contact</h4>
                <div class="hline"></div>
                <p><b>Name:</b> ${job.contact.name}</p>
                <p><b>Phone Number:</b> ${job.contact.phoneNumber}</p>
                <p><b>Email:</b> ${job.contact.email}</p>
            </div>
        </div>
    </c:if>
    <c:if test="${empty job}">
        <h3>Sorry, this job post is not found</h3>
    </c:if>
</div>

<c:import url="../fragments/footer.jsp" />
