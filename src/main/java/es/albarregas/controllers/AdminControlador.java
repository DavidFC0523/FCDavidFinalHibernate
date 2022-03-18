package es.albarregas.controllers;

import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Tutor;
import es.albarregas.beans.Usuario;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.models.UsuarioModelo;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Controlador", urlPatterns = {"/control"})
public class AdminControlador extends HttpServlet {

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
            throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
        HttpSession misession = request.getSession(true);
        /**Comprobamos si la sesion esta Iniciada*/
        if (misession.getAttribute("usuario") != null) {
            //Llamada y creacion de variables
            DAOFactory daof = DAOFactory.getDAOFactory();
            IGenericoDAO pdao = daof.getGenericoDAO();
            Tutor tutor = new Tutor();
            Ciclo ciclo = new Ciclo();
            String url = null;
            switch (request.getParameter("op")) {
                case "AddTutor":
                 /**Opcion Agregar Tutor*/
                try {
                    BeanUtils.populate(tutor, request.getParameterMap());
                    if (request.getParameter("Idciclo") != "" && request.getParameter("Idciclo") != null) {
                        ciclo = (Ciclo) pdao.selectById(request.getParameter("Idciclo"), Ciclo.class);
                        BeanUtils.copyProperty(tutor, "ciclo", ciclo);
                    }
                    /**Asignamos Constantes*/
                    
                    tutor.setAvatar("avatar.png");
                    tutor.setPassword(UsuarioModelo.encriptar("123"));
                    tutor.setRol(Usuario.Rol.TUTOR);
                } catch (IllegalAccessException | InvocationTargetException ex) {
                    ex.printStackTrace();
                }
                pdao.insertUpdate(tutor);
                url = "./JSP/Admin/InicioAdmin.jsp";
                break;
                
                case "EliminarTutor":
                /*Eliminamos Tutor**/
                    url = "./JSP/Admin/InicioAdmin.jsp";
                    String[] registro = request.getParameterValues("registro");
                    /**Eliminamos todos los tutores seleccionados*/
                    if (registro != null) {
                        if (registro.length != 0) {
                            for (String x : registro) {
                                Tutor tutorElim = new Tutor();
                                System.out.println(x);
                                tutorElim = (Tutor) pdao.selectById(Integer.parseInt(x), Tutor.class);
                                pdao.delete(tutorElim);
                            }
                        }
                    }
                    break;
            }
            request.getRequestDispatcher(url).forward(request, response);

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
        try {
            processRequest(request, response);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AdminControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AdminControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AdminControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AdminControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
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
