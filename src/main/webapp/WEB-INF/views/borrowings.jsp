<%@ include file="fragments/header.jspf" %>
<%@ include file="fragments/navigation.jspf" %>

<div class="container">
    <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th>Customer</th>
            <th>Title</th>
            <th>Author</th>
            <th>Category</th>
            <th>Rental Date</th>
            <th>Return Date</th>
            <th>Option</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${empty borrowings}">
            <td colspan="7">No Rentals found</td>
        </c:if>

        <c:forEach items="${borrowings}" var="borrowing">
        <tr>
            <td>${borrowing.customer.firstName} ${borrowing.customer.lastName}</td>
            <td>${borrowing.book.title}</td>
            <td>${borrowing.book.author.firstName} ${borrowing.book.author.lastName}</td>
            <td>${borrowing.book.category.name}</td>
            <td>${borrowing.rentalDate}</td>
            <td <c:if test="${borrowing.overdue}">class="alert alert-danger"</c:if>>${borrowing.returnDate}</td>
            <td>
                <a class="btn btn-primary btn-sm" href="/return/${borrowing.id}">Return</a>
            </td>
        </tr>
        </c:forEach>

        </tfoot>
    </table>
</div>

<%@ include file="fragments/footer.jspf" %>

