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
import java.util.HashMap;
import java.util.Map;
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
        String archivo = getServletConfig().getServletContext().getRealPath("/static/img/grafica.png");
        String file = getServletConfig().getServletContext().getRealPath("/static/archivo.txt");
        Map<String, String> imagenesMap = new HashMap<>();
        Map<String, String> archivosMap = new HashMap<>();
        imagenesMap.put("grafica", archivo);
        archivosMap.put("Reporte.txt", file);
        if (email != null) {
            try {
                EnvioEmail e = new EnvioEmail();
                e.setAsunto("Recuperar contraseña de Instituto");
                e.setDestinatario(email);
                Usuario u = dao.findByEmail(email);
                if (u != null) {
                    String mensaje = "<h1>Bienvenido a Instituto</h1><br><h2>Tu contraseña es:</h2> " 
                            + u.getPassword() + "<img src=\"cid:grafica\"/> <p>Tambien te mandamos un reporte.txt solo por los memes</p>";
                    e.setMensaje(mensaje);
                    e.enviar(imagenesMap, archivosMap);
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
