<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
           <title>Quarto</title>
    </head>
    <body>
        <h1>Quarto</h1>
        <table width='100%'>

            <tr bgcolor='#c0c0c0'>
                <td>Número</td>
                <td>Andar</td>
                <td>Qntd Hospedes</td>
                <td>Categoria</td>
                <td>valor</td>
             
            </tr>
            <%
                Class.forName("org.postgresql.Driver");

                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/reservascom",
                        "postgres", "root");

                String SQL = "SELECT * FROM quartos";

                Statement stm = conn.createStatement();


                ResultSet rs = stm.executeQuery(SQL);
                while (rs.next()) {

            %>
            <tr>
                <td><%=rs.getString("numero")%></td>
                <td><%=rs.getString("andar")%></td>
                <td><%=rs.getString("qtdeHospede")%></td>
                <td><%=rs.getString("categoria")%></td>
                <td><%=rs.getString("valor")%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
