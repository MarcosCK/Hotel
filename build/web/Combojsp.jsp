<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
           <title>COMBOS</title>
    </head>
    <body>
        <h1>Combo</h1>
        <table width='100%'>

            <tr bgcolor='#c0c0c0'>
                <td>Nome Combo</td>
                <td>Valor</td>
             
            </tr>
            <%
                Class.forName("org.postgresql.Driver");

                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/reservascom",
                        "postgres", "Churkin3112#");

                String SQL = "SELECT * FROM combo";

                Statement stm = conn.createStatement();


                ResultSet rs = stm.executeQuery(SQL);
                while (rs.next()) {

            %>
            <tr>
                <td><%=rs.getString("nome")%></td>
                <td><%=rs.getString("valor")%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>