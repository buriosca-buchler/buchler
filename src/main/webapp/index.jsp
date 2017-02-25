<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Context initContext = new InitialContext();
DataSource ds = null;
boolean ok = false;
try {
	Context envContext  = (Context) initContext.lookup("java:jboss/datasources");	
	ds = (DataSource) envContext.lookup("BuchlerDS");
} catch (Exception e) {
	try {
		Context envContext  = (Context) initContext.lookup("java:/comp/env");
		ds = (DataSource) envContext.lookup("jboss/datasources/BuchlerDS");
	} catch (Exception exc) {
		exc.printStackTrace();
	}
}
System.out.println("index.jsp.ds: " + ds);
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Burios.CZ - Buchler 2017</title>
</head>
<body>
	index.jsp.dsxxx:<%=ds%>
</body>
</html>