/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.AlumnoDao;
import dao.CarreraDao;
import dao.UsuarioDao;
import dao.impl.AlumnoDaoImpl;
import dao.impl.CarreraDaoImpl;
import dao.impl.UsuarioDaoImpl;
import dto.Alumno;
import dto.Usuario;
import java.io.IOException;
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
 * Created on 10-Mar-2019
 */
@WebServlet(name="AlumnosServlet", urlPatterns={"/alumnos"})
public class AlumnosServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("ver"))
            mostrarAlumnos(request, response);
        else if (action.equals("eliminar"))
            eliminarAlumno(request, response);
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void mostrarAlumnos(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            request.setAttribute("PAGINA", 7);
            AlumnoDao dao = new AlumnoDaoImpl();
            CarreraDao daoCarrera = new CarreraDaoImpl();
            List<Alumno> alumnos = dao.readAll();
            for (Alumno alumno : alumnos) {
                alumno.setCarrera(daoCarrera.read(alumno.getCarrera()));
            }
            request.setAttribute("alumnos", alumnos);
            request.getRequestDispatcher("listaAlumnos.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarAlumno(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            UsuarioDao dao = new UsuarioDaoImpl();
            int id = Integer.parseInt(request.getParameter("id"));
            Usuario usuario = new Usuario();
            usuario.setId(id);
            dao.delete(usuario);
            response.sendRedirect("alumnos?action=ver");
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
