<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>

<s:setDataSource driver="oracle.jdbc.OracleDriver"
			url="jdbc:oracle:thin:@localhost:1521:xe"
			user="java166" password="1234" var="db"/>
			
<c:set value="986" var="id"/>			
<c:set value="bottle" var="name"/>
<c:set value="98" var="cost"/>	
<c:set value="9" var="q"/>

<s:transaction dataSource="${db}">
<s:update>
insert into product values(?,?,?,?)
<s:param value="${id}"></s:param>
<s:param value="${name}"></s:param>
<s:param value="${cost}"></s:param>
<s:param value="${q}"></s:param>
</s:update>	
<s:update>
update product set q=91 where pid=986
</s:update>		
</s:transaction>		
<s:query var="rs" dataSource="${db}">
 	select * from product
</s:query>
<table>
<tr>
<th>Pid</th>
<th>Name</th>
<th>cost</th>
<th>qty</th>
</tr>
<c:forEach var="pd" items="${rs.rows}">
<tr>
	<td>${pd.pid}</td>
	<td>${pd.pname}</td>
	<td>${pd.cost}</td>
	<td>${pd.quantity}</td>
</tr>
</c:forEach>
</table>



</body>
</html>