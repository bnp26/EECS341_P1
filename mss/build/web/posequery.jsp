<%-- 
    Document   : main
    Created on : Mar 15, 2017, 8:08:57 PM
    Author     : bnp26
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EECS 341</title>
    </head>
    <body>
        <h1>Query #1</h1>
        
        Run A Query!<br />
        <form action="executequery.jsp" method="get">
            <input type="text" name="query" value=""/>
            
            <br /><br />
            <input type="submit" value="SUBMIT"/>
            <input type="reset" value="CLEAR"/>
        </form>
    </body>
</html>
