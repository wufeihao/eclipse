<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>update success</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h4>please input book's information in here</h4>
    <s:form action ="update" method = "post">
    	<s:textfield name = "Title" label="book title"/>
    	<s:textfield name = "AuthorID" label="book AuthorID"/>
    	<s:textfield name = "PublisherData" label="book PublisherData"/>
    	<s:textfield name = "Publisher" label="book Publisher"/>
    	<s:textfield name = "Price" label="book price"/>
    	<s:submit/>
    </s:form>
  </body>
</html>
