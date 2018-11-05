<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="content/header.jsp"/>


<div class="row">

    <c:forEach items="${categories}" var="category">
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <a href="/categories/${category.id}"><img src="holder.js/242x200"></a>
                <div class="caption">
                    <h3>${category.name}</h3>
                </div>
            </div>
        </div>
    </c:forEach>

</div>

<jsp:include page="content/footer.jsp"/>
