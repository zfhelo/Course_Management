<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/stu_bar.jsp"%>
<title>成员</title>
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <ul class="list-group list-group-flush">
                <c:forEach items="${MEMBER}" var="s">
                    <li class="list-group-item">${s.nickname}</li>
                </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
