<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
<style type="text/css">
.txt{
	 font-size:2em;
	 color: green;
	}
	input[type=text], input[type=password]{
	width:80%;
	padding:12px 20px;
	margin: 8px 0;
	box-sizing:border-box;
	border-radius:25px;
	border: 4px solid #ccc;
	}
	
	input[type=text]:focus{
	border:4px solid #555;
	}
	
	input[type=password]:focus{
	border:4px solid #555;
	}
	
	input[type=submit], input[type=reset]{
	width:30%;
	background-color:#4CAF50;
	border:none;
	border-radius: 15px;
	color:white;
	padding:16px 32px;
	text-decoration:none;
	margin: 14px 32px;
	cursor:pointer;
	}
</style>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="p" value="${sessionScope.product}"/>

 <h2>
              <c:if test="${p != null}">
               Edit Product
              </c:if>
              <c:if test="${p == null}">
               Add New Product
              </c:if>
             </h2>
<form action="add" method="post">

<label class="txt" >PID</label>
 <input type="text" name="pid" readonly="readonly" 
 value="<c:out value='${p.pid}'/>"><br/>
<label class="txt">Product Name</label>
<input type="text" name="pname" 
value="<c:out value='${p.pname}'/>"><br/>
<label class="txt">Cost</label>
<input type="text" name="cost" 
value="<c:out value='${p.cost}'/>"><br/>
<label class="txt">Quantity</label>
<input type="text" name="qty" value="<c:out value='${p.quantity}'/>">

<input type="submit" value="Add Product">




<input type="reset" value="Cancel">
</form>
</body>
</html>