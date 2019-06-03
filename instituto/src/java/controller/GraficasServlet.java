/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.AlumnoDao;
import dao.impl.AlumnoDaoImpl;
import dto.Datos;
import dto.Usuario;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import utils.EnvioEmail;
import utils.Paginas;

/**
 *
 * @author tonatihu
 * Created on 10-Mar-2019
 */
@WebServlet(name="GraficasServlet", urlPatterns={"/graficas"})
public class GraficasServlet extends HttpServlet {
     private static final Logger LOGGER = Logger.getLogger(GraficasServlet.class.getName());
   
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
        String accion = request.getParameter("action");
        if (accion.equals("ver"))
            ver(request, response);
        else if (accion.equals("generar"))
            enviar(request, response);
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

    private void ver(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException, ServletException {
        try {
            request.setAttribute("PAGINA", Paginas.GRAFICAS);
            AlumnoDao dao = new AlumnoDaoImpl();
            List<Datos> datos = dao.getData();
            request.setAttribute("lista", datos);
            generarGrafica(datos);
            request.getRequestDispatcher("graficas.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GraficasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void enviar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("USUARIO_SESSION");
        EnvioEmail e = new EnvioEmail();
        e.setAsunto("Envio de la cantidad de alumnos");
        e.setDestinatario(u.getEmail());
        String archivo = getServletConfig().getServletContext().getRealPath("/static/img/grafica.png");
        Map<String, String> imagenesMap = new HashMap<>();
        Map<String, String> archivosMap = new HashMap<>();
        imagenesMap.put("grafica", archivo);
        String mensaje = "<h1>Bienvenido a Instituto</h1><br><h2>Te mandamos una grafica bien chida</h2> <img src=\"cid:grafica\"/> ";
        e.setMensaje(mensaje);
        e.enviar(imagenesMap, archivosMap);
        response.sendRedirect("graficas?action=ver");
    }
}
