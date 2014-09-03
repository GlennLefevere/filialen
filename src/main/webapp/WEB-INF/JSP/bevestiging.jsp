<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bevestiging</title>
</head>
<body>
	<c:if test="${not empty verwijderd}">
		<ul>
			<c:forEach items="${verwijderd}" var="filiaal">
			<li>${filiaal.naam} ${filiaal.waardeGebouw}</li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>