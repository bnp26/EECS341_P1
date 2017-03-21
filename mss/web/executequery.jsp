<%-- 
    Document   : executequery
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
    <body>
        
        <%
    try{
        MySQLConnector sqlConnector = new MySQLConnector();
        String query = request.getParameter("query");
        %>
        <h2>QUERY=</h2>
        <h4><%=query%></h4>
        
        <%
        ResultSet result;
        result = sqlConnector.callQuery(query);
        result.setFetchSize(5);

        ResultSetMetaData rsmd = result.getMetaData();
        int colNum = rsmd.getColumnCount();
        %>
        <table>
    <% while(result.next()) { %>
        <tr>
    <%  for(int x = 1; x<=colNum; x++) { %>
            <td>
        <% String col = result.getObject(x).toString(); %>
            <%=col%>
            </td>
        <%
            }
        %>
        </tr>
        <%
        }
        result.close();
        sqlConnector.closeConnection();
    } catch(Exception ex) {
        System.out.println(ex.toString());
    }
    %>
    </table>    
    
        
    </body>
</html>
