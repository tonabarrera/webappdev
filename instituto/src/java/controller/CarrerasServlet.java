/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.CarreraDao;
import dao.impl.CarreraDaoImpl;
import dto.Carrera;
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
@WebServlet(name="CarrerasServlet", urlPatterns={"/carreras"})
public class CarrerasServlet extends HttpServlet {
   
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
        switch (action) {
            case "ver":
                verCarreras(request, response);
                break;
            case "eliminar":
                eliminarCarrera(request, response);
                break;
            case "editar":
                editarCarrera(request, response);
                break;
            case "agregar":
                agregarCarrera(request, response);
                break;
            case "guardar":
                guardarCarrera(request, response);
                break;
            default:
                response.sendRedirect("home");
                break;
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

    private void verCarreras(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            request.setAttribute("PAGINA", 3);
            CarreraDao dao = new CarreraDaoImpl();
            List<Carrera> carreras = dao.readAll();
            request.setAttribute("carreras", carreras);
            request.getRequestDispatcher("listaCarreras.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CarrerasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarCarrera(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.valueOf(request.getParameter("id"));
            CarreraDao dao = new CarreraDaoImpl();
            Carrera c = new Carrera();
            c.setId(id);
            dao.delete(c);
            response.sendRedirect("carreras?action=ver");
        } catch (IOException | SQLException ex) {
            Logger.getLogger(CarrerasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editarCarrera(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            CarreraDao dao = new CarreraDaoImpl();
            int id = Integer.valueOf(request.getParameter("id"));
            Carrera c = new Carrera();
            c.setId(id);
            c = dao.read(c);
            request.setAttribute("carrera", c);
            request.setAttribute("PAGINA", 3);
            request.getRequestDispatcher("formCarrera.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CarrerasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarCarrera(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setAttribute("PAGINA", 4);
        request.getRequestDispatcher("formCarrera.jsp").forward(request, response);
    }

    private void guardarCarrera(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        response.sendRedirect("carreras?action=ver");
    }

}
