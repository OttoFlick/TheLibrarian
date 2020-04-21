<%@ include file="fragments/header.jspf" %>
<%@ include file="fragments/navigation.jspf" %>

<div class="container">
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">${errorMessage}</div>
    </c:if>

    <form:form modelAttribute="user" method="post">
      <div class="form-row">
        <div class="form-group col-md-6">
          <label for="inputEmail4">Email</label>
          <form:input path="login" type="email" class="form-control" />
        </div>
        <div class="form-group col-md-6">
          <label for="inputPassword4">Password</label>
          <form:input path="password" type="password" class="form-control" />
        </div>
      </div>
      <button type="submit" class="btn btn-primary">Login</button>
    </form:form>
</div>

<%@ include file="fragments/footer.jspf" %>