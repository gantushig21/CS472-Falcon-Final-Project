<%--
  Created by IntelliJ IDEA.
  User: gantushig
  Date: 5/10/20
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../fragments/header.jsp">
    <c:param name="title" value="Jobs" />
</c:import>

<div class="container mtb">
    <div class="row">
        <div class="col-lg-8">
            <c:forEach items="${jobs}" var="item">
                <div class="job-card job-search-card">
                    <div class="job-card-header">
                        <div style="display: flex; padding-left: 80px;">
                            <div style="display: flex; justify-content: space-between;">
                                <div>
                                    <h5>
                                        <a href="#">${item.title}</a>
                                    </h5>
                                    <div class="job-card-company">
                                        <a href="#">${item.company}</a>
                                        <i class="fa fa-map-marker"></i>
                                        <span>${item.location}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="job-card-body">
                        <div style="display: flex; flex-wrap: wrap;">
                            <div style="margin-right: 20px;">
                                <i class="fa fa-fw fa-briefcase" style="margin-right: 5px;"></i>
                                <span>${item.status}</span>
                            </div>
                            <div>
                                <i class="fa fa-clock-o" style="margin-right: 5px;"></i>
                                <span>
                                    <fmt:formatDate value="${item.postDate}" type="date"/>
                                </span>
                            </div>
                        </div>
                        <div class="job-card-description">
                            ${item.description}
                        </div>
                        <div class="job-card-footer" style="text-align: right;">
                            <a href="jobs/detail?id=${item.id}" class="btn btn-large btn-theme">Continue</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <c:if test="${jobs.size() gt 0}">
                <div id="job-list-pagination">
                    <ul class="pagination">
                        <li><a href="jobs?action=list&page=${activePage - 1}&limit=${limit}&q=${q}&location=${location}">«</a></li>
                        <c:forEach var="i" begin="${begin}" end="${end}">
                            <li class="<c:if test = "${i == activePage}">active</c:if>">
                                <a href="jobs?action=list&page=${i}&limit=${limit}&q=${q}&location=${location}">${i}</a>
                            </li>
                        </c:forEach>
                        <li><a href="jobs?action=list&page=${activePage + 1}&limit=${limit}&q=${q}&location=${location}">»</a></li>
                    </ul>
                </div>
            </c:if>
            <c:if test="${jobs.size() eq 0}">
                <h3>No records found</h3>
            </c:if>
        </div>
    </div>
</div>


<c:import url="../fragments/footer.jsp" />