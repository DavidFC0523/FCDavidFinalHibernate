/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Tutor;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.models.EnumConverter;
import es.albarregas.models.UsuarioModelo;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

/**
 *
 * @author gared
 */
@WebServlet(name = "AlumnosControlador", urlPatterns = {"/AlumnosControlador"})
public class AlumnosControlador extends HttpServlet {

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
        
        HttpSession misession = request.getSession(true);
        /**Comprobamos si la Sesion esta iniciada*/
        if (misession.getAttribute("usuario")!= null){
        /**Creacion de Variables y llamada a objetos*/
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO pdao = daof.getGenericoDAO();
        Tutor tutor = new Tutor();
        Ciclo ciclo = new Ciclo();
        String url = null;
        Alumno alumno = new Alumno();
   
        switch (request.getParameter("op")) {
            case "CambiarContrasenia":
                /**Introduciomos los Datos del Alumno para Actualizarlos*/
                String Contrasenia = request.getParameter("password1");
                alumno = (Alumno) misession.getAttribute("usuario");
                alumno = (Alumno) pdao.selectById(alumno.getIdUsuario(), Alumno.class);
               
                try {
                    DateConverter converter = new DateConverter();
                    converter.setPattern("yyyy-MM-dd");
                    ConvertUtils.register(converter, Date.class);
                    ConvertUtils.register(new EnumConverter(), Alumno.Genero.class);
                    BeanUtils.populate(alumno, request.getParameterMap());

                } catch (IllegalAccessException | InvocationTargetException ex) {
                    //Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, null, ex);
                }
                /**Encriptamos la Contraseña*/
                alumno.setPassword(UsuarioModelo.encriptar(Contrasenia));
                pdao.insertUpdate(alumno);
                url = "./JSP/Alumno/InicioAlumno.jsp";
                misession.setAttribute("usuario", alumno);
                break;                    
        }
        request.getRequestDispatcher(url).forward(request, response);
        }else{
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
