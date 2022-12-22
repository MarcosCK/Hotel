
package hotel.dados.servlet;

import com.reserva.pessoas.Hospede;
import com.reserva.servicos.Alimentacao;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/HospedeServlet"})
public class HospedeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
         String email = request.getParameter("email");   
          String cpf = request.getParameter("cpf");   
           double renda = Double.valueOf(request.getParameter("renda"));
        
        Hospede a = new Hospede();
//        try {
//            a.adicionar(nome, email, cpf, renda);
//        } catch (SQLException ex) {
//            Logger.getLogger(HospedeServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
           
           
               
      //   Hotel hotel = new Hotel (nome, email, cpf, renda );
        // Connection connection = ConnectionFactory.getConnection();
       //  HotelDAO dao = new HotelDAO(connection)
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   }
}

