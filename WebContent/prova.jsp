<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>prodotto!</h1>
	
	<p>
		<% Product p = (Product)request.getAttribute("product"); %>
		Nome: <% out.print(p.getName()); %> <br/>
		url:  <% out.print(p.getUrl()); %> <br/>
	</p>

</body>
</html>