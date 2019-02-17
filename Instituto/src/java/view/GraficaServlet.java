/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.AlumnoDao;
import dao.AlumnoDaoImpl;
import dto.Datos;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
 */
@WebServlet(name = "GraficaServlet", urlPatterns = {"/GraficaServlet"})
public class GraficaServlet extends HttpServlet {

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
            out.println("<title>Servlet GraficaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String archivo = getServletConfig().getServletContext().getRealPath("/grafica.png");
            JFreeChart chart = ChartFactory.createPieChart("TITULO", getGraficaAlumnos(), true, true, false);
            ChartUtilities.saveChartAsPNG(new File(archivo), chart, 700, 400);
            out.println("<img src='./grafica.png'/>");
            out.println("<h1>Servlet GraficaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
        }
    }
    
    private DefaultPieDataset getGraficaAlumnos() {
        DefaultPieDataset dpd = new DefaultPieDataset();
        try {
            AlumnoDao dao = new AlumnoDaoImpl();
            List<Datos> datos = dao.getData();
            for (Datos d : datos) {
                dpd.setValue(d.getNombre(), d.getCantidad());
            }
        } catch (SQLException ex) {
            Logger.getLogger(GraficaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dpd;
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
