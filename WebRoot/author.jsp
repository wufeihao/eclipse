<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>author's data</title>
    
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
    this is author's data <br>
  	id is <s:property value="author.AuthorId"/>
    ,name is <s:property value="author.Name"/>
    ,age is <s:property value="author.Age"/>
    ,country is <s:property value="author.Country"/><br>
    this is book's data <br>
    ISBN is <s:property value="book.ISBN"/>
    , Title is <s:property value="book.Title"/>
    , AuthorID is <s:property value="book.AuthorID"/>
    , Publisher is <s:property value="book.Publisher"/>
    , PublisherData is <s:property value="book.PublisherData"/>
    , Price is <s:property value="book.Price"/>
  </body>
</html>
