/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.reserva.servicos.Alimentacao;
import com.reserva.servicos.Quartos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raide
 */
@WebServlet(urlPatterns = {"/QuartosServlet"})
public class QuartosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String numero = request.getParameter("numero");
         String andar = request.getParameter("andar");
          String hospede = request.getParameter("hospede");
           String categoria = request.getParameter("categoria");
            String valor = request.getParameter("valor");
  
          
          
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet QuartosServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3> Numero : " + numero);
            out.println("<h3> Andar : " + andar);
            out.println("<h3> Hospedes : " + hospede);
            out.println("<h3> Categoria : " + categoria);
            out.println("<h3> Valor Total : " + valor);
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String numero = request.getParameter("numero");
         String andar = request.getParameter("andar");
         String hospede = request.getParameter("hospede");   
          String categoria = request.getParameter("categoria");    
           double valor = Double.valueOf(request.getParameter("valor"));
        
        Quartos a = new Quartos();
        try {
            a.adicionar(numero, andar, hospede, categoria, valor);
        } catch (SQLException ex) {
            Logger.getLogger(QuartosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
