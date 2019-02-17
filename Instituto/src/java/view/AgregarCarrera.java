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
@WebServlet(name = "AgregarCarrera", urlPatterns = {"/AgregarCarrera"})
public class AgregarCarrera extends HttpServlet {

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
            out.println("<title>Servlet AgregarAlumno</title>");
            out.println("</head>");
            out.println("<body>");
            String mensajeAMostrar = "";
            String nombreCarrera = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String tipo = request.getParameter("tipo");
            System.out.println(tipo);
            Carrera c = new Carrera();
            c.setNombre(nombreCarrera);
            c.setDescripcion(descripcion);
            c.setDuracion(Integer.parseInt(request.getParameter("duracion")));
            CarreraDao dao = new CarreraDaoImpl();
            
            try {
                if (tipo.equals("alta")) {
                    dao.create(c);
                    mensajeAMostrar = "El Registro se agregó satisfactoriamente";
                } else {
                    c.setId(Integer.parseInt(request.getParameter("id")));
                    dao.update(c);
                    mensajeAMostrar = "El regustro se actualizo satisfactoriamente";
                }
            } catch (SQLException ex) {
                mensajeAMostrar = "No se pudó agregar el registro" + ex.toString();
                Logger.getLogger(AgregarCarrera.class.getName()).log(Level.SEVERE, null, ex);
            }

            out.println("<div align='center'>");
            out.println( mensajeAMostrar +"<br/><br/>");
            out.println("<a href='MostrarCarrera'> Lista de Carreras </a>");
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
