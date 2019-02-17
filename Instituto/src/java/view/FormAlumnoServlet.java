/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CarreraDao;
import dao.CarreraDaoImpl;
import dto.Carrera;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "FormAlumnoServlet", urlPatterns = {"/FormAlumnoServlet"})
public class FormAlumnoServlet extends HttpServlet {

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
            out.println("<title>Servlet FormAlumnoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Datos del Alumno</h1>");
            CarreraDao dao = new CarreraDaoImpl();
            
            try {
                List<Carrera> carreras = dao.readAll();
                out.println("<form action='AgregarAlumnoServlet' method='post'");
                out.println("<p>Boleta: <input type='number' name='boleta' required/></p>");
                out.println("<p>Nombre: <input type='text' name='nombre' required/></p>");
                out.println("<p>Apellido Paterno: <input type='text' name='apPaterno' required/></p>");
                out.println("<p>Apellido Materno: <input type='text' name='apMaterno' required/></p>");
                out.println("<p>Correo: <input type='email' name='correo' required/></p>");
                
                out.println("<p>Carrera: ");
                out.println("<select name='carrera' required>");
                for (Carrera c : carreras) {
                    out.println("<option value='"+c.getId()+"'>"+c.getNombre()+"</option>");
                }
                out.println("</select>");
                out.println("</p>");
                out.println("<p><input type='submit' value='Enviar'/></p>");
                out.println("</form>");
            } catch (SQLException ex) {
                String mensajeAMostrar = "No se pudó mostrar el formulario de Alumnos" + ex.toString();
                out.println("<div align='center'>");
                out.println(mensajeAMostrar + "<br/><br/>");
                out.println("</div>");
                Logger.getLogger(FormAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
