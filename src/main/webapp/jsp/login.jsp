<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
   <h1>Login</h1>
   <form name='f' action="login" method='POST'>
      <table>
         <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
  </form>
  <br/>
  <c:if test="${not empty sessionScope.message}">
    <span style="color:red"><c:out value="${sessionScope.message}"/></span>
    <c:remove var="message" scope="session" />
  </c:if>
</body>
</html>