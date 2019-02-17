/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AlumnoDao;
import dao.AlumnoDaoImpl;
import dao.CarreraDao;
import dao.CarreraDaoImpl;
import dto.Alumno;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tonatihu
 */
@WebServlet(name = "VerAlumnosServlet", urlPatterns = {"/VerAlumnosServlet"})
public class VerAlumnosServlet extends HttpServlet {

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
            out.println("<link rel=\"stylesheet\" "
                    + "href=\"https://use.fontawesome.com/releases/v5.7.2/css/all.css\" "
                    + "integrity=\"sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr\" "
                    + "crossorigin=\"anonymous\">");
            out.println("<title>Servlet MostrarCarrera</title>");
            out.println("</head>");
            out.println("<body>");
            
            AlumnoDao dao = new AlumnoDaoImpl();
            CarreraDao daoCarrera = new CarreraDaoImpl();
            
            try {
                 out.println("<h3 align='center'>Lista de Alumnos</h3>");
                out.println("<table align='center' border='1' width='60%'");
                out.println("<tr>");
                out.println("<th>Boleta</th>");
                out.println("<th>Nombre</th>");
                out.println("<th>Apellido Paterno</th>");
                out.println("<th>Apellido Materno</th>");
                out.println("<th>Correo</th>");
                out.println("<th>Carrera</th>");
                out.println("<th>Acciones<table><tr><td>Ver</td>"
                        + "<td>Actualizar</td><td>Eliminar</td></tr></table></th>");
                out.println("</tr>");
                List<Alumno> alumnos = dao.readAll();
                
                for (Alumno alumno : alumnos) {
                    alumno.setCarrera(daoCarrera.read(alumno.getCarrera()));
                    out.println("<tr>");
                    out.println("<td><a href='VerAlumnoServlet?id=" + alumno.getNoBoleta() + "' >" + alumno.getNoBoleta() + "</a></td>");
                    out.println("<td>" + alumno.getNombre() + "</td>");
                    out.println("<td>" + alumno.getApPaterno()+ "</td>");
                    out.println("<td>" + alumno.getApMaterno()+ "</td>");
                    out.println("<td>" + alumno.getEmail()+ "</td>");
                    out.println("<td>" + alumno.getCarrera().getNombre() + "</td>");
                    out.println("<td><table><tr>"
                            + "<td><a href='EliminarAlumnoServlet?id=" + alumno.getNoBoleta() + "' ><i class='fas fa-trash'></i></a></td>"
                            + "<td><a href='VerAlumnoServlet?id=" + alumno.getNoBoleta() + "'><i class='fas fa-eye'></i></a></td>"
                            + "<td><a href='FormAlumnoServlet?id=" + alumno.getNoBoleta() + "'><i class='fas fa-edit'></i></a></td>"
                            + "</tr></table></td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } catch (SQLException ex) {
                String mensajeAMostrar = "No se pudó mostrar el listado de Alumnos" + ex.toString();
                out.println("<div align='center'>");
                out.println(mensajeAMostrar + "<br/><br/>");
                out.println("</div>");
                Logger.getLogger(VerAlumnosServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            out.println("<div align='center'>");
            out.println("<a href='FormAlumnoServlet'>Agregar Alumno</a>");
            out.println("</div>");
            
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
