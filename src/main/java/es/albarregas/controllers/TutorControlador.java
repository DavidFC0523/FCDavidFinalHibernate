/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Modulo;
import es.albarregas.beans.Nota;
import es.albarregas.beans.Tutor;
import es.albarregas.beans.Usuario;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IUsuarioDAO;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.models.EnumConverter;
import es.albarregas.models.UsuarioModelo;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
@WebServlet(name = "TutorControlador", urlPatterns = {"/TutorControlador"})
public class TutorControlador extends HttpServlet {

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

        if (misession.getAttribute("usuario") != null) {
            DAOFactory daof = DAOFactory.getDAOFactory();
            IGenericoDAO pdao = daof.getGenericoDAO();
            IUsuarioDAO puser = daof.getUsuarioDAO();
            Tutor tutor = new Tutor();
            Ciclo ciclo = new Ciclo();
            String url = null;
            Alumno alumno = new Alumno();
            switch (request.getParameter("op")) {
                case "CambiarContrasenia":
                    /**
                     * Insertamos los datos del tutor la primera vez que ingresa
                     */
                    String Contrasenia = request.getParameter("password1");
                    tutor = (Tutor) misession.getAttribute("usuario");
                    tutor = (Tutor) pdao.selectById(tutor.getIdUsuario(), Tutor.class);

                    try {
                        DateConverter converter = new DateConverter();
                        converter.setPattern("yyyy-MM-dd");
                        ConvertUtils.register(converter, Date.class);
                        ConvertUtils.register(new EnumConverter(), Alumno.Genero.class);
                        BeanUtils.populate(tutor, request.getParameterMap());
                    } catch (IllegalAccessException | InvocationTargetException ex) {
                        //Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    /**
                     * Encriptamos la Contraseña
                     */
                    tutor.setPassword(UsuarioModelo.encriptar(Contrasenia));
                    pdao.insertUpdate(tutor);
                    misession.setAttribute("usuario", tutor);
                    url = "./JSP/Tutor/InicioTutor.jsp";
                    break;

                case "AddAlumno":
                    /**
                     * Agregamos el Alumno
                     */
                    tutor = (Tutor) misession.getAttribute("usuario");
                    if (puser.comprobarEmail(request.getParameter("email")).size() == 0) {
                        try {
                            DateConverter converter = new DateConverter();
                            converter.setPattern("yyyy-MM-dd");
                            ConvertUtils.register(converter, Date.class);
                            ConvertUtils.register(new EnumConverter(), Alumno.Genero.class);
                            BeanUtils.populate(alumno, request.getParameterMap());

                        } catch (IllegalAccessException | InvocationTargetException ex) {
                            //Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        /**
                         * Metemos los datos por defecto del alumno
                         */
                        alumno.setCiclo(tutor.getCiclo());
                        alumno.setPassword(UsuarioModelo.encriptar("123"));
                        alumno.setRol(Usuario.Rol.ALUMNO);
                        alumno.setAvatar("avatar.png");
                        alumno.setGenero(Alumno.Genero.Mujer);
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                        Date date = new Date(System.currentTimeMillis());
                        alumno.setFechaNacimiento(date);
                        /**
                         * Creamos sus notas para sus modelos
                         */
                        ciclo = tutor.getCiclo();
                        Set<Modulo> modColeccion = ciclo.getModulos();
                        Set<Nota> notasColec = new HashSet<Nota>();
                        int contadorprueba = 0;
                        for (Modulo x : modColeccion) {
                            Nota nota = new Nota();
                            contadorprueba++;
                            nota.setAlumno(alumno);
                            nota.setModulo(x);
                            nota.setNota(Short.parseShort("1"));
                            notasColec.add(nota);
                        }
                        alumno.setNotas(notasColec);
                        pdao.insertUpdate(alumno);
                        url = "./JSP/Tutor/InicioTutor.jsp";

                    } else {
                        url = "./JSP/Tutor/InicioTutor.jsp";
                    }

                    break;
                case "EliminarTutor":
                    /**Eliminamos el Alumno*/
                    url = "./JSP/Tutor/InicioTutor.jsp";
                    String[] registro = request.getParameterValues("registro");
                    if (registro != null) {
                        if (registro.length != 0) {
                            for (String x : registro) {
                                Alumno AlumnoElim = new Alumno();
                                AlumnoElim = (Alumno) pdao.selectById(Integer.parseInt(x), Alumno.class);
                                pdao.delete(AlumnoElim);

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
