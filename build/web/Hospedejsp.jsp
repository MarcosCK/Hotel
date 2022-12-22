<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
           <title>HOSPEDE</title>
    </head>
    <body>
        <h1>Hospedes</h1>
        <table width='100%'>

            <tr bgcolor='#c0c0c0'>
                <td>Nome</td>
                <td>Email</td>
                <td>CPF</td>
                <td>Renda</td>
             
            </tr>
            <%
                Class.forName("org.postgresql.Driver");

                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/reservascom",
                        "postgres", "admin");

                String SQL = "SELECT * FROM hospede";

                Statement stm = conn.createStatement();


                ResultSet rs = stm.executeQuery(SQL);
                while (rs.next()) {

            %>
            <tr>
                <td><%=rs.getString("nome")%></td>
                <td><%=rs.getString("email")%></td>
                <td><%=rs.getString("cpf")%></td>
                <td><%=rs.getString("renda")%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
