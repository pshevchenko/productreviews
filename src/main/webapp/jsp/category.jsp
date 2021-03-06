<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="content/header.jsp"/>

<div class="row">

    <c:forEach items="${category.products}" var="product">
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <a href="/products/${product.id}"><img src="holder.js/242x200"></a>
                <div class="caption">
                    <h3>${product.name}</h3>
                    <p>${product.description}</p>
                </div>
            </div>
        </div>
    </c:forEach>

</div>

<jsp:include page="content/footer.jsp"/>



