<%-- 
    Document   : server
    Created on : Mar 15, 2017, 9:10:00 PM
    Author     : bnp26
--%>

<%@page language="java" import="mss.MySQLConnector"%>
<%@page language="java" import="java.sql.*"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><%
    try{
        MySQLConnector sqlConnector = new MySQLConnector();
        
        //sqlConnector.
    } catch(Exception ex) {
        System.out.println(ex.toString());
    }
    %>
        <h1>QUERY #1</h1><br/>
        
    </body>
</html>
