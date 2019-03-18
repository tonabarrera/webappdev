/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.AlumnoDao;
import dao.impl.AlumnoDaoImpl;
import dao.CarreraDao;
import dao.impl.CarreraDaoImpl;
import dao.ProfesorDao;
import dao.impl.ProfesorDaoImpl;
import dto.Alumno;
import dto.Carrera;
import dto.Profesor;
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
import javax.servlet.http.HttpSession;
import utils.Paginas;

/**
 *
 * @author tonatihu
 * Created on 09-Mar-2019
 */
@WebServlet(name="PerfilServlet", urlPatterns={"/perfil"})
public class PerfilServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("USUARIO_SESSION");
        int tipo = usuario.getTipo();
        request.setAttribute("PAGINA", Paginas.PERFIL);
        if (tipo == 1) {
            try {
                CarreraDao dao = new CarreraDaoImpl();
                AlumnoDao daoAlumno = new AlumnoDaoImpl();
                Alumno a = daoAlumno.findByUsername(usuario.getUsername());
                List<Carrera> carreras = dao.readAll();
                request.setAttribute("carreras", carreras);
                request.setAttribute("alumno", a);
                request.getRequestDispatcher("perfilAlumno.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(PerfilServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
             try {
                ProfesorDao profesorDao = new ProfesorDaoImpl();
                Profesor profesor = profesorDao.findByUsername(usuario.getUsername());
                request.setAttribute("profesor", profesor);
                request.getRequestDispatcher("perfilProfesor.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(PerfilServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

}
