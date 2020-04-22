<%@ include file="fragments/header.jspf" %>
<%@ include file="fragments/navigation.jspf" %>

<div class="container">
    <div class="jumbotron jumbotron-fluid">
      <div class="container">
        <h1 class="display-4">Borrow ${borrowing.book.title}</h1>
        <p class="lead">${borrowing.book.category.name} by ${borrowing.book.author.firstName} ${borrowing.book.author.lastName}</p>
      </div>
    </div>

    <form:form modelAttribute="borrowing" method="post">
      <form:hidden path="book.id" />
      <div class="form-group">
        <label for="from">From</label> <form:errors path="rentalDate" class="text-danger" />
        <form:input path="rentalDate" type="date" class="form-control" id="from" name="from" />
      </div>
      <div class="form-group">
        <label for="till">Till</label> <form:errors path="returnDate" class="text-danger" />
        <form:input path="returnDate" type="date" class="form-control" id="till" name="till" />
      </div>
      <button type="submit" class="btn btn-primary">Borrow</button>
      <a class="btn btn-secondary" href="/book/list">Cancel</a>
    </form:form>
</div>

<%@ include file="fragments/footer.jspf" %>