/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Tutor;
import es.albarregas.beans.Usuario;
import es.albarregas.dao.ICicloDAO;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IModuloDAO;
import es.albarregas.dao.IUsuarioDAO;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.models.UsuarioModelo;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "Redireccionar", urlPatterns = {"/Redireccionar"})
public class Redireccionar extends HttpServlet {

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

            String op = request.getParameter("op");
            DAOFactory daof = DAOFactory.getDAOFactory();
            IGenericoDAO pdao = daof.getGenericoDAO();
            IUsuarioDAO puser = daof.getUsuarioDAO();
            ICicloDAO pcil = daof.getCicloDAO();
            IModuloDAO pmod = daof.getModuloDAO();

            String url = "./JSP/login.jsp";
            /**Redirecciones*/
            switch (op) {
                case "InsertarTutor":
                    request.setAttribute("Ciclos", pcil.getCiclosSinTutor());
                    url = "./JSP/Admin/InsertarTutor.jsp";
                    break;
                    
                case "ListarProfesor":
                    request.setAttribute("lista", puser.listaProfesorAlumno());
                    url = "./JSP/Admin/ListarTutorAlumno.jsp";
                    break;
                    
                case "EliminarTutor":
                    request.setAttribute("tutores", puser.getTutorSinAlumno());
                    url = "./JSP/Admin/EliminarTutor.jsp";
                    break;

                case "CambiarDatosTutor":
                    url = "./JSP/Tutor/ActualizarTutor.jsp";
                    break;

                case "AltaAlumno":
                    url = "./JSP/Tutor/InsertarAlumno.jsp";
                    break;

                case "EliminarAlumno":
                    /**Comprobamos si Tiene Alumnos*/
                    Tutor tutor = (Tutor) misession.getAttribute("usuario");
                    String IdCiclo = "";
                    if (tutor.getCiclo() != null) {
                        IdCiclo = tutor.getCiclo().getIdCiclo();
                        List<Object[]> lista = puser.listaAlumnoPorProfesor(IdCiclo);
                        request.setAttribute("alumnos", lista);
                        url = "./JSP/Tutor/EliminarAlumno.jsp";
                    } else {
                        url = "./JSP/Tutor/InicioTutor.jsp";;
                        String mensaje = "Usted no tiene Alumnos, por lo que no puede Eliminar Alumnos";
                        request.setAttribute("mensajeErr", mensaje);
                    }
                    break;
                    
                case "NotasExamenes":
                    /**Comprobamos si tiene Alumnos*/
                    tutor = (Tutor) misession.getAttribute("usuario");
                    if (tutor.getCiclo() != null) {
                        IdCiclo = tutor.getCiclo().getIdCiclo();
                        List<Usuario> lista = puser.listaAlumnoNotas(IdCiclo);
                        request.setAttribute("alumnos", lista);
                        url = "./JSP/Tutor/NotasAlumno.jsp";
                    } else {
                        url = "./JSP/Tutor/InicioTutor.jsp";
                        String mensaje = "Usted no tiene Alumnos, por lo que no puede modificar las notas de los examenes";
                        request.setAttribute("mensajeErr", mensaje);
                    }
                    break;
                   
                case "ListarAlumno":
                    tutor = (Tutor) misession.getAttribute("usuario");
                    /**Comprobamos si tiene Alumnos*/
                    if (tutor.getCiclo() != null) {
                        IdCiclo = tutor.getCiclo().getIdCiclo();
                        List<Object[]> lista = puser.listaUsuarioNotaMedia(IdCiclo);
                        List<Alumno> listaOrdenada = UsuarioModelo.alumnoNotaPonderada(lista);
                        request.setAttribute("lista", listaOrdenada);
                        url = "./JSP/Tutor/NotasAlumnoMedia.jsp";
                    } else {
                        url = "./JSP/Tutor/InicioTutor.jsp";
                        String mensaje = "Usted no tiene Alumnos, por lo que no puede listar los alumnos";
                        request.setAttribute("mensajeErr", mensaje);
                    }

                    break;

                case "CambiarDatosAlumno":
                    url = "./JSP/Alumno/ActualizarAlumno.jsp";
                    break;

                case "VerNotas":
                    url = "./JSP/Alumno/VerNotas.jsp";
                    break;
                case "VerModulos":
                    url = "./JSP/Alumno/VerNotas.jsp";
                    break;

                case "VerModulosAlumno":
                    Alumno alumno = (Alumno) misession.getAttribute("usuario");
                    IdCiclo = alumno.getCiclo().getIdCiclo();
                    List<Object[]> ModuloColec = pmod.moduloPorCiclo(IdCiclo);
                    request.setAttribute("ColeccionModulo", ModuloColec);
                    url = "./JSP/Alumno/VerModulos.jsp";
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
