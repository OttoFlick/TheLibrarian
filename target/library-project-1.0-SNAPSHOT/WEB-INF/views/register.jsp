<%@ include file="fragments/header.jspf" %>
<%@ include file="fragments/navigation.jspf" %>

<div class="container">
    <form:form modelAttribute="register" method="post">
        <div class="form-row">
        <div class="form-group col-md-6">
          <label for="inputEmail4">Email</label> <form:errors path="login" class="text-danger" />
          <form:input path="login" type="email" class="form-control" />
        </div>
        <div class="form-group col-md-6">
          <label for="inputPassword4">Password</label> <form:errors path="password" class="text-danger" />
          <form:input path="password" type="password" class="form-control" />
        </div>
      </div>
      <div class="form-group">
        <label for="inputName">First Name</label> <form:errors path="firstName" class="text-danger" />
        <form:input path="firstName" type="text" class="form-control" />
      </div>
      <div class="form-group">
        <label for="inputLastName">Last Name</label> <form:errors path="lastName" class="text-danger" />
        <form:input path="lastName" type="text" class="form-control" />
      </div>
      <div class="form-group">
        <label for="inputAddress">Street</label> <form:errors path="street" class="text-danger" />
        <form:input path="street" type="text" class="form-control" />
      </div>
      <div class="form-group">
        <label for="inputAddress2">Number</label> <form:errors path="number" class="text-danger"/>
        <form:input path="number" type="text" class="form-control" />
      </div>
      <div class="form-row">
        <div class="form-group col-md-6">
          <label for="inputCity">City</label> <form:errors path="city" class="text-danger"/>
          <form:input path="city" type="text" class="form-control" />
        </div>
        <div class="form-group col-md-2">
          <label for="inputZip">Zip</label> <form:errors path="zipCode" class="text-danger"/>
          <form:input path="zipCode" type="text" class="form-control" />
        </div>
      </div>
      <button type="submit" class="btn btn-primary">Register</button>
    </form:form>
</div>

<%@ include file="fragments/footer.jspf" %>