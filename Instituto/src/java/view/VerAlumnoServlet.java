/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.AlumnoDao;
import dao.AlumnoDaoImpl;
import dao.CarreraDao;
import dao.CarreraDaoImpl;
import dto.Alumno;
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
@WebServlet(name = "VerAlumnoServlet", urlPatterns = {"/VerAlumnoServlet"})
public class VerAlumnoServlet extends HttpServlet {

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
            out.println("<title>Servlet VerAlumnoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3 align='center'>Datos de la Carrera</h3>");
            out.println("<table align='center' border='1' width='60%'");
            
            AlumnoDao dao = new AlumnoDaoImpl();
            CarreraDao daoCarrera = new CarreraDaoImpl();
            Alumno alumno = new Alumno();
            alumno.setNoBoleta(Long.valueOf(request.getParameter("id")));
            try {
                alumno = dao.read(alumno);
                alumno.setCarrera(daoCarrera.read(alumno.getCarrera()));
            } catch (SQLException ex) {
                Logger.getLogger(VerAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (alumno != null) {
                out.println("<tr>");
                out.println("<th>Boleta</th><td>" + alumno.getNoBoleta()+ "</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th>Nombre</th><td>" + alumno.getNombre() + "</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th>Apellido Paterno</th><td>" + alumno.getApPaterno()+ "</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th>Apellido Materno</th><td>" + alumno.getApMaterno()+ "</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th>Correo</th><td>" + alumno.getEmail()+ "</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th>Carrera</th><td>" + alumno.getCarrera().getNombre() + "</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("<div align='center'>");
                out.println("<a href='EliminarAlumnoServlet?id=" + alumno.getNoBoleta() +" '> Eliminar Alumno </a>");
                out.println("&nbsp; &nbsp; &nbsp;");
                out.println("<a href='MostrarCarrera'> Lista de Alumnos </a>");
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