<%-- 
    Document   : Hotel
    Created on : 18/04/2022, 19:16:25
    Author     : raide
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
           <title>HOTEIS</title>
    </head>
    <body>
        <h1>Hoteis</h1>
        <table width='100%'>

            <tr bgcolor='#c0c0c0'>
                <td>Hotel</td>
                <td>Cnpj</td>
                <td>Estado</td>
                <td>Cidade</td>
             
            </tr>
            <%
                Class.forName("org.postgresql.Driver");

                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/reservascom",
                        "postgres", "Churkin3112#");

                String SQL = "SELECT * FROM hotel";

                Statement stm = conn.createStatement();


                ResultSet rs = stm.executeQuery(SQL);
                while (rs.next()) {

            %>
            <tr>
                <td><%=rs.getString("nome")%></td>
                <td><%=rs.getString("cnpj")%></td>
                <td><%=rs.getString("estado")%></td>
                <td><%=rs.getString("cidade")%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
