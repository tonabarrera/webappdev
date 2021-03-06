/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CarreraDAO;
import dao.CarreraDAOImpl;
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

/**
 *
 * @author tonatihu
 */
@WebServlet(name = "VerCarrera", urlPatterns = {"/VerCarrera"})
public class VerCarrera extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VerCarrera</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h3 align='center'>Datos de la Carrera</h3>");
            out.println("<table align='center' border='1' width='60%'");
            CarreraDAO dao = new CarreraDAOImpl();
            Carrera carrera = new Carrera();
            carrera.setId(Integer.parseInt(request.getParameter("id")));
            try {
                carrera = dao.read(carrera);
            } catch (SQLException ex) {
                Logger.getLogger(VerCarrera.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (carrera != null) {
            out.println("<tr>");
            out.println("<th> Id Carrera </th><td>" + carrera.getId() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th> Nombre Carrera </th><td>" + carrera.getNombre() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th> Descripci&oacute;n Carrera </th><td>" + carrera.getDescripcion() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th> Duraci&oacute;n Carrera </th><td>" + carrera.getDuracion() + "</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<div align='center'>");
            out.println("<a href='EliminarCarrera?id=" + carrera.getId() +" '> Eliminar Carrera </a>");
            out.println("&nbsp; &nbsp; &nbsp;");
            out.println("<a href='MostrarCarrera'> Lista de Carreras </a>");
            out.println("</div>");
            }

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
