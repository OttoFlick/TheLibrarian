<%@ include file="fragments/header.jspf" %>
<%@ include file="fragments/navigation.jspf" %>

<div class="container">
    <form:form class="form-inline" modelAttribute="search" method="post">
      <div class="form-group mx-sm-3 mb-2">
        <form:input path="searchString" class="form-control" placeholder="Enter category, title or author"/>
      </div>
      <button type="submit" class="btn btn-primary mb-2">Search</button>
    </form:form>

    <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Category</th>
            <th>Option</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${empty books}">
        <td colspan="4">No books found</td>
        </c:if>

        <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>${book.author.firstName} ${book.author.lastName}</td>
            <td>${book.category.name}</td>
            <td>
                <a class="btn btn-primary btn-sm" href="/borrow/${book.id}">Borrow</a>
            </td>
        </tr>
        </c:forEach>

        </tfoot>
    </table>
</div>

<%@ include file="fragments/footer.jspf" %>

