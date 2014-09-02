<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/themes/smoothness/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/index.js"></script>
<link rel="stylesheet" href="${contextPath}/styles/index.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Afwaarderen</title>
</head>
<body>
<h1>Afwaarderen</h1>
<select multiple size="10" id="niet">
<c:if test="${not empty filialen}">
<c:forEach items="${filialen}" var="filiaal">
<option value="${filiaal.id}">${filiaal.naam}</option>
</c:forEach>
</c:if>
</select>
<div id="knoppenMid">
<span id="right" class="knop">&gt;</span>
<span id="allright" class="knop">&gt;&gt;</span>
<span id="left" class="knop">&lt;</span>
<span id="allleft" class="knop">&lt;&lt;</span>
</div>
<form:form action="" method="post" commandName="">
<div>
<form:select path="" id="wel"/>
<input type="submit" value="Afwaarderen" id="afwaarderen" disabled>
</div>
</form:form>
<!--TOODOO form aanpassen voor submit --> 
</body>
</html>