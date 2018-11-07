<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="content/header.jsp"/>

<div class="panel panel-default">
    <div class="panel-body">

        <div class="row">

            <div class="col-xs-6 col-md-4">
                <img src="holder.js/350x300">
            </div>

            <div class="col-xs-12 col-md-8">
                <h1>Product</h1>
                <p class="lead"> ${product.name} </p>
                <p>${product.description}</p>
            </div>

        </div>

        <p class="lead"> Reviews </p>
        <ul class="list-group">
            <c:forEach items="${product.reviews}" var="review">
                <li class="list-group-item">${review.text}</li>
            </c:forEach>
        </ul>


        <form:form method="POST" class="navbar-form navbar-center" action="/products/${product.id}/reviews"
                   modelAttribute="review">
            <div class="form-group">
                <form:input path="text" class="form-control" placeholder="Write your review"/>

            </div>

            <form:input path="productId" type="hidden" value="${product.id}"/>
            <input type="submit" class="btn btn-default" value="Submit"/>
        </form:form>


    </div>
</div>


<jsp:include page="content/footer.jsp"/>


