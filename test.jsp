<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String num1 = (String)request.getAttribute("num1");
String num2 = (String)request.getAttribute("num2");
String num3 = (String)request.getAttribute("num3");

out.println(num1);
out.println(num2);
out.println(num3);

String val1 = request.getParameter("key1");
String val2 = request.getParameter("key2");
String val3 = request.getParameter("key3");

out.println(val1);
out.println(val2);
out.println(val3);
%>
</body>
</html>


http://127.0.0.1:8090/web_test/test.jsp
