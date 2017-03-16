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
        <form action="server1.jsp" method="get">
            Get the titles and years of movies that are starred by <input type="text" size="30px" default="Meryl Streep">
            <input type="submit" value="RUN"/>    
        </form><br />
        <form action="server2.jsp" method="get">
            Get the titles and years of the longest movies from each studio!
            <input type="submit" value="RUN"/>    
        </form><br />
        <form action="server3.jsp" method="get">
            Get the richest producer for <input type="text" size="30px" default="MGM"> Studios!
            <input type="submit" value="RUN"/>    
        </form><br />
        <form action="server4.jsp" method="get">
            Find out what which movie stars only star in movies made by studios with the same address as theirs!
            <input type="submit" value="RUN"/>    
        </form><br />
        <form action="server5.jsp" method="get">
            Which actor/s or actress/s starred in all of the movies produced by MGM studios!
            <input type="submit" value="RUN"/>    
        </form>
    </body>
</html>
