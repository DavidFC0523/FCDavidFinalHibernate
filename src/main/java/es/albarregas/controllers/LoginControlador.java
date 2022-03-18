/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Administrador;
import es.albarregas.beans.Alumno;
import es.albarregas.beans.Tutor;
import es.albarregas.beans.Usuario;
import es.albarregas.beans.Usuario.Rol;
import es.albarregas.dao.ICicloDAO;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IUsuarioDAO;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.models.UsuarioModelo;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gared
 */
@WebServlet(name = "LoginControlador", urlPatterns = {"/LoginControlador"})
public class LoginControlador extends HttpServlet {

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
        /**
         * Creacion de Variables
         */
        String url = "";
        String email = request.getParameter("Email");
        String password = request.getParameter("Contrasenia");
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO pdao = daof.getGenericoDAO();
        IUsuarioDAO puser = daof.getUsuarioDAO();
        ICicloDAO pcil = daof.getCicloDAO();
        Usuario resultado = puser.comprobarLogin(email, UsuarioModelo.encriptar(password));
        if (resultado != null) {
            HttpSession misession = request.getSession(true);
            /**Si es un Admin*/
            if (resultado.getRol() == Rol.ADMIN) {
                Administrador user = new Administrador();
                user = (Administrador) pdao.selectById(resultado.getIdUsuario(), Administrador.class);
                misession.setAttribute("usuario", user);
                request.setAttribute("Ciclos", pcil.getCiclosSinTutor());
                if (user != null) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());
                    user.setUltimoAcceso(date);
                    pdao.insertUpdate(user);
                }

                url = "./JSP/Admin/InicioAdmin.jsp";
            }
            if (resultado.getRol() == Rol.ALUMNO) {
                Alumno user = new Alumno();
                user = (Alumno) pdao.selectById(resultado.getIdUsuario(), Alumno.class);
                /**Comprueba si es la primera vez*/
                if (resultado.getUltimoAcceso() == null) {
                    url = "./JSP/Alumno/CambiarContrasenia.jsp";
                } else {
                    url = "./JSP/Alumno/InicioAlumno.jsp";
                }
                if (resultado != null) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());
                    resultado.setUltimoAcceso(date);
                    pdao.insertUpdate(resultado);
                }
                misession.setAttribute("usuario", user);
            }
            if (resultado.getRol() == Rol.TUTOR) {
                Tutor user = new Tutor();
                user = (Tutor) pdao.selectById(resultado.getIdUsuario(), Tutor.class);
                /**Si es Tutor*/
                if (resultado.getUltimoAcceso() == null) {
                    url = "./JSP/Tutor/CambiarContrasenia.jsp";
                } else {
                    url = "./JSP/Tutor/InicioTutor.jsp";
                }
                if (resultado != null) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());
                    resultado.setUltimoAcceso(date);
                    pdao.insertUpdate(resultado);
                }
                misession.setAttribute("usuario", user);
            }
        } else {
            url = "./JSP/login.jsp";
        }

        request.getRequestDispatcher(url).forward(request, response);
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
