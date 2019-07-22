<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<c:set var="employees">
	<employees>
		<employee>
			<eid>4567</eid>
			<ename>Pavithra</ename>
			<salary>34566</salary>
		</employee>
		<employee>
			<eid>4568</eid>
			<ename>Hema</ename>
			<salary>44566</salary>
		</employee>
		<employee>
			<eid>4569</eid>
			<ename>Supragna</ename>
			<salary>54566</salary>
		</employee>
	</employees>
</c:set>
<x:parse xml="${employees}" var="emps"/>
<x:choose>
	<x:when select="$emps//employee/ename = 'Pavithra1'">
	Pavitha is a good employee
	</x:when>
		<x:when select="$emps//employee/ename = 'Hema'">
	Hema is a  better employee
	</x:when>
	<x:otherwise>
	    employee not available
	</x:otherwise>
</x:choose>
<ul>
<x:forEach select="$emps//employee/ename" var="n">
	<li><x:out select="$n"/></li>
</x:forEach>
</ul>

</body>
</html>