/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.UsuarioDao;
import dao.impl.UsuarioDaoImpl;
import dto.Alumno;
import dto.Profesor;
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
 * @author tonatihu
 * Created on 09-Mar-2019
 */
@WebServlet(name="Signup", urlPatterns={"/signup"})
public class SignupServlet extends HttpServlet {
   
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
        if (request.getMethod().equals("POST")) {
            String nombre = request.getParameter("nombre");
            String apPaterno = request.getParameter("apPaterno");
            String apMaterno = request.getParameter("apMaterno");
            String email = request.getParameter("email");
            int tipo = Integer.valueOf(request.getParameter("tipo"));
            String username = request.getParameter("username");
            String contra = request.getParameter("password");
            String boleta = request.getParameter("boleta");
            UsuarioDao userDao = new UsuarioDaoImpl();
            try {
                if (tipo == 1) {
                    Alumno a = new Alumno();
                    a.setApMaterno(apMaterno);
                    a.setApPaterno(apPaterno);
                    a.setBoleta(boleta);
                    a.setEmail(email);
                    a.setNombre(nombre);
                    a.setType(tipo);
                    a.setUsername(username);
                    a.setPassword(contra);
                    userDao.create(a);

                } else {
                    Profesor p = new Profesor();
                    p.setApMaterno(apMaterno);
                    p.setApPaterno(apPaterno);
                    p.setNumeroProfesor(boleta);
                    p.setEmail(email);
                    p.setNombre(nombre);
                    p.setType(tipo);
                    p.setUsername(username);
                    p.setPassword(contra);
                    userDao.create(p);
                }
                response.sendRedirect("home");
                return;
            } catch (SQLException ex) {
                Logger.getLogger(SignupServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        request.getRequestDispatcher("signup.jsp").forward(request, response);
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
