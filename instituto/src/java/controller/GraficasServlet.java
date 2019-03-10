/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.AlumnoDao;
import dao.impl.AlumnoDaoImpl;
import dto.Datos;
import java.io.File;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author tonatihu
 * Created on 10-Mar-2019
 */
@WebServlet(name="GraficasServlet", urlPatterns={"/graficas"})
public class GraficasServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("PAGINA", 8);
            AlumnoDao dao = new AlumnoDaoImpl();
            List<Datos> datos = dao.getData();
            request.setAttribute("lista", datos);
            generarGrafica(datos);
            request.getRequestDispatcher("graficas.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GraficasServlet.class.getName()).log(Level.SEVERE, null, ex);
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

    private void generarGrafica(List<Datos> datos) throws IOException {
        DefaultPieDataset dpd = new DefaultPieDataset();
        datos.forEach((d) -> {
            dpd.setValue(d.getNombre(), d.getCantidad());
        });
        String archivo = getServletConfig().getServletContext().getRealPath("/static/img/grafica.png");
        JFreeChart chart = ChartFactory.createPieChart("Cantidad de alumnos por carrera", 
               dpd, true, true, false);
        ChartUtilities.saveChartAsPNG(new File(archivo), chart, 400, 300);
    }

}
