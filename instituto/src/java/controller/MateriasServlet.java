/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.CarreraDao;
import dao.MateriaDao;
import dao.ProfesorDao;
import dao.impl.CarreraDaoImpl;
import dao.impl.MateriaDaoImpl;
import dao.impl.ProfesorDaoImpl;
import dto.Carrera;
import dto.Materia;
import dto.Profesor;
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
@WebServlet(name="MateriasServlet", urlPatterns={"/materias"})
public class MateriasServlet extends HttpServlet {
   
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
            mostrarMaterias(request, response);
        else if (action.equals("agregar"))
            agregarMateria(request, response);
        else if (action.equals("eliminar"))
            eliminarMateria(request, response);
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

    private void mostrarMaterias(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        try {
            request.setAttribute("PAGINA", 5);
            MateriaDao dao = new MateriaDaoImpl();
            CarreraDao daoMateria = new CarreraDaoImpl();
            ProfesorDao daoProfesor = new ProfesorDaoImpl();
            List<Materia> materias = dao.readAll();
            Carrera c = new Carrera();
            Profesor p = new Profesor();
            for (Materia m : materias) {
                c.setId(m.getCarrera().getId());
                m.setCarrera(daoMateria.read(c));
                p.setNumeroProfesor(m.getProfesor().getNumeroProfesor());
                m.setProfesor(daoProfesor.read(p));
            }
            request.setAttribute("materias", materias);
            request.getRequestDispatcher("listaMaterias.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MateriasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarMateria(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setAttribute("PAGINA", 6);
        request.getRequestDispatcher("formMateria.jsp").forward(request, response);
    }

    private void eliminarMateria(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            int id = Integer.valueOf(request.getParameter("id"));
            MateriaDao dao = new MateriaDaoImpl();
            Materia m = new Materia();
            m.setId(id);
            dao.delete(m);
            response.sendRedirect("materias?action=ver");
        } catch (IOException | SQLException ex) {
            Logger.getLogger(CarrerasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
