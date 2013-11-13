<%-- 
    Document   : MonJSP
    Created on : 13 nov. 2013, 13:18:57
    Author     : Aymeric
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page JSP</title>
</head>
<body>
	<h1>Recupération des valeurs en JSP</h1>
	<% 
		String nom= request.getParameter("champTexte");
		out.print("<p> Vous vous appelez "+ nom);
	
                String aimer= request.getParameter("chk");
                out.print("<p> Vous aimez le "+ aimer);
                
                String champTextarea= request.getParameter("champTextarea");
                 out.print("<p> Autre: "+ champTextarea);
        %>
	 
</body>
</html>
