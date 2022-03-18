/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import es.albarregas.beans.Nota;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IUsuarioDAO;
import javax.servlet.http.HttpSession;

@MultipartConfig
/**
 *
 * @author gared
 */
@WebServlet(name = "ControladorAjax", urlPatterns = {"/ControladorAjax"})
public class ControladorAjax extends HttpServlet {

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
        HttpSession misession = request.getSession(true);
        /**Aqui realizamos los metodos de las llamadas ajax*/
        if (misession.getAttribute("usuario") != null) {
            DAOFactory daof = DAOFactory.getDAOFactory();
            IGenericoDAO pdao = daof.getGenericoDAO();
            IUsuarioDAO puser = daof.getUsuarioDAO();
            /**Comprobar correo*/
            if (request.getParameter("Accion").equals("comprobarEmail")) {
                String email = request.getParameter("Email");
                System.out.println(email);
                List<Object[]> respuesta = puser.comprobarEmail(email);
                String employeeJsonString = new Gson().toJson(respuesta);
                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(employeeJsonString);
                out.flush();
            }
          /**Cambiar nota de lso Alumnos*/
            if (request.getParameter("Accion").equals("CambiarNota")) {
                String idNota = request.getParameter("idNota");
                String Nota = request.getParameter("nota");
                Nota notaCambiar = (Nota) pdao.selectById(Integer.parseInt(idNota), Nota.class);
                notaCambiar.setNota(Short.parseShort(Nota));
                pdao.insertUpdate(notaCambiar);
                String employeeJsonString = new Gson().toJson("");
                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(employeeJsonString);
                out.flush();
            }
        } else {
            request.getRequestDispatcher("./JSP/login.jsp").forward(request, response);
        }
    }

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
