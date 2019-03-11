/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.UsuarioDao;
import dao.impl.UsuarioDaoImpl;
import dto.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.EnvioEmail;

/**
 *
 * @author tonatihu
 * Created on 09-Mar-2019
 */
@WebServlet(name="ForgotPassword", urlPatterns={"/forgotPassword"})
public class RecuperarContraServlet extends HttpServlet {
   
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
        String email = request.getParameter("email");
        UsuarioDao dao = new UsuarioDaoImpl();
        if (email != null) {
            try {
                EnvioEmail e = new EnvioEmail();
                e.setAsunto("Recuperar contraseña");
                e.setDestinatario(email);
                Usuario u = dao.findByEmail(email);
                if (u != null) {
                    String mensaje = "Tu contraseña es: " + u.getPassword();
                    e.setMensaje(mensaje);
                    e.enviar();
                    response.sendRedirect("login");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(RecuperarContraServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
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
