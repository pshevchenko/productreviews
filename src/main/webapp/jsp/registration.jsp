<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="content/header.jsp"/>


<%--@elvariable id="customer" type="com.astound.presentation.productreviews.entities.Customer"--%>

<div class="col-md-6 col-md-offset-3">
    <form:form method="POST" class="col-md-6 col-md-offset-3" action="/registration"
               modelAttribute="customer">
        <div class="form-group">
            <form:input path="name" class="form-control" placeholder="Name"/>
        </div>
        <div class="form-group">
            <form:input path="login" class="form-control" placeholder="Login"/>
        </div>
        <div class="form-group">
            <form:password path="password" class="form-control" placeholder="Password"/>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</div>

<div class="col-md-6 col-md-offset-3">
    <br>
    <p class="lead"> Users </p>
    <ul class="list-group">
        <c:forEach items="${customers}" var="cust">
            <li class="list-group-item"> ${cust}</li>
        </c:forEach>
    </ul>
</div>

<jsp:include page="content/footer.jsp"/>
