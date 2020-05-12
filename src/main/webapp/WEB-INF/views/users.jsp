<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../fragments/header.jsp">
    <c:param name="title" value="login Page" />
</c:import>

<main>
    <div class="container">
        <h2 class="display-4">List of Contact Messages</h2>
        <p>To see all rows use <span style="font-size: 13px; color: red">*</span> in search</p>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">firstname</th>
                <th scope="col">mail</th>
                <th scope="col">gender</th>
                <th scope="col">phone</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}" varStatus="iteration">
                    <tr>
                        <th scope="row"><c:out value="${iteration.index+1}"></c:out>.</th>
                        <td><c:out value="${user.firstName}"></c:out> </td>
                        <td><c:out value="${user.email}"></c:out></td>
                        <td><c:out value="${user.gender}"></c:out></td>
                        <td><c:out value="${user.phone}"></c:out></td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
</main>

<c:import url="../fragments/footer.jsp" />
