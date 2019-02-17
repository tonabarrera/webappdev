/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CarreraDaoImpl;
import dto.Carrera;
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
import dao.CarreraDao;

/**
 *
 * @author tonatihu
 */
@WebServlet(name = "EditarCarrera", urlPatterns = {"/EditarCarrera"})
public class EditarCarrera extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            CarreraDao dao = new CarreraDaoImpl();
            Carrera carrera = new Carrera();
            carrera.setId(Integer.parseInt(request.getParameter("id")));
            try {
                carrera = dao.read(carrera);
            } catch (SQLException ex) {
                Logger.getLogger(VerCarrera.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditarCarrera</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>EditarCarrera</h1>");
            out.println("<form action=\"AgregarCarrera\" method=\"post\">");
            out.println("<p><label>Nombre de la carrera:</label><input type=\"text\" name=\"nombre\" value='" + carrera.getNombre()+ "'></p>");
            out.println("<p><label>Descipcion de la carrera:</label><input type=\"text\" name=\"descripcion\" value='" + carrera.getDescripcion()+ "'></p>");
            out.println("<p><label>Duracion de la carrera:</label><input type=\"number\" name=\"duracion\" value='" + carrera.getDuracion()+ "'></p>");
            out.println("<input hidden name=\"tipo\" value=\"cambio\">");
            out.println("<input hidden name=\"id\" value='" + carrera.getId() +"'>");
            out.println("<input type=\"submit\" value=\"Enviar\">");
            out.println("</form>");
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
