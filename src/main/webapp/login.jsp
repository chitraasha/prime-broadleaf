<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.springframework.security.web.authentication.AuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.web.authentication.AbstractProcessingFilter" %>
<%@ page import="org.springframework.security.core.AuthenticationException" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:p="http://primefaces.prime.com.tr/ui">>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<form action="j_spring_security_check">
	<label for="j_username">Username</label>
	<input type="text" name="j_username" id="j_username" <c:if test="${not empty param.login_error}">value='<%= session.getAttribute(AuthenticationProcessingFilter.SPRING_SECURITY_LAST_USERNAME_KEY) %>'</c:if>/>
	<br/>
	<label for="j_password">Password</label>
	<input type="password" name="j_password" id="j_password"/>
	<br/>
	<input type='checkbox' name='_spring_security_remember_me'/> Remember me on this computer.
	<br/>
	<input type="submit" value="Login"/>
</form>
</body>
</html>