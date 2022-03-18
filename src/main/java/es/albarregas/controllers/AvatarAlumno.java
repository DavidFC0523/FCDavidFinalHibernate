/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;
import es.albarregas.beans.Alumno;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.models.AvatarModelo;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.beanutils.BeanUtils;
@MultipartConfig
/**
 *
 * @author gared
 */
@WebServlet(name = "AvatarAlumno", urlPatterns = {"/AvatarAlumno"})
public class AvatarAlumno extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
         DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO pdao = daof.getGenericoDAO();
        
        String url = "./JSP/Alumno/InicioAlumno.jsp";
        HttpSession misession = request.getSession(true);
        Alumno alumno = new Alumno();
       alumno = (Alumno) misession.getAttribute("usuario");
        if (alumno != null){
            /**Introducimos los Datos de actualizacion*/
        try {
            BeanUtils.populate(alumno, request.getParameterMap());
            String dirImagen = request.getServletContext().getRealPath("/IMAGENES/AVATARES/");
            Part filePart = request.getPart("avatar");
            alumno.setAvatar(AvatarModelo.subirAvatar(filePart, dirImagen, alumno));
            pdao.insertUpdate(alumno);
            
        } catch (IllegalAccessException ex) {

        } catch (InvocationTargetException ex) {

        }
        request.getRequestDispatcher(url).forward(request, response);     
        }else {
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
