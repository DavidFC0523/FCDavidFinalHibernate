package es.albarregas.dao;

import es.albarregas.beans.Administrador;
import es.albarregas.beans.Alumno;
import es.albarregas.beans.Modulo;
import es.albarregas.beans.Tutor;
import es.albarregas.beans.Usuario;
import es.albarregas.beans.Usuario.Rol;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.models.UsuarioModelo;
import java.io.Serializable;
import es.albarregas.persistencia.HibernateUtil;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class UsuarioDAO extends GenericoDAO implements IUsuarioDAO {

    DAOFactory daof = DAOFactory.getDAOFactory();
    IGenericoDAO pdao = daof.getGenericoDAO();

    public Usuario comprobarLogin(String email, String password) {
        String hql = "FROM Usuario AS u WHERE u.email = :email AND u.password = :password";
        Usuario usuario = new Usuario();
        try {
            this.startSession();
            Query query = sesion.createQuery(hql);
            query.setParameter("email", email);
            query.setParameter("password", password);
            usuario = (Usuario) query.uniqueResult();
        } catch (HibernateException he) {
            if (sesion != null) {
                this.handleException(he);
            }
        } finally {
            if (sesion != null) {
                this.endSession();
            }
        }
        return usuario;
    }

    @Override
    public List<Object[]> comprobarEmail(String email) {
        String hql = "Select u.email FROM Usuario AS u WHERE u.email = :email";
        List<Object[]> listaResultados = null;
        try {
            this.startSession();
            Query query = sesion.createQuery(hql);
            query.setParameter("email", email);
            listaResultados = query.list();
        } catch (HibernateException he) {
            if (sesion != null) {
                this.handleException(he);
            }
        } finally {
            this.endSession();
        }
        return listaResultados;
    }

    @Override
    public List<Object[]> getTutorSinAlumno() {
        String hql = "select t.idUsuario, t.email,t.nombre from Tutor as t  LEFT JOIN Alumno as a on a.ciclo.idCiclo = t.ciclo.idCiclo where a.idUsuario = null";
        List<Object[]> listaResultados = null;        try {
            this.startSession();

            Query query = sesion.createQuery(hql);
            listaResultados = query.list();
        } catch (HibernateException he) {
            if (sesion != null) {
                this.handleException(he);
            }
        } finally {
            this.endSession();
        }
        return listaResultados;
    }

    public List<Object[]> listaProfesorAlumno() {
        String hql = "Select t.email,t.nombre, a.email FROM Tutor AS t LEFT JOIN Alumno AS a ON  t.ciclo.idCiclo = a.ciclo.idCiclo";
        List<Object[]> listaResultados = null;
        try {
            this.startSession();
            Query query = sesion.createQuery(hql);
            listaResultados = query.list();

        } catch (HibernateException he) {
            if (sesion != null) {
                this.handleException(he);
            }
        } finally {
            this.endSession();
        }
        return listaResultados;
    }

    @Override
    public List<Object[]> listaAlumnoPorProfesor(String ciclo) {
        String hql = "Select a.idUsuario ,a.nombre FROM Alumno AS a WHERE a.ciclo.idCiclo = :idCiclo";
        List<Object[]> listaResultados = null;
        try {
            this.startSession();
            Query query = sesion.createQuery(hql);
            query.setParameter("idCiclo", ciclo);
            listaResultados = query.list();

        } catch (HibernateException he) {
            if (sesion != null) {
                this.handleException(he);
            }
        } finally {
            this.endSession();
        }
        return listaResultados;
    }

    @Override
    public List<Usuario> listaAlumnoNotas(String ciclo) {
        String hql = "FROM Alumno AS a WHERE a.ciclo.idCiclo = :idCiclo ";
        List<Usuario> listaResultados = null;
        try {
            this.startSession();
            Query query = sesion.createQuery(hql);
            query.setParameter("idCiclo", ciclo);
            listaResultados = query.list();

        } catch (HibernateException he) {
            if (sesion != null) {
                this.handleException(he);
            }
        } finally {
            this.endSession();
        }
        return listaResultados;
    }

    @Override
    public List<Object[]> listaUsuarioNotaMedia(String ciclo) {
        String hql = "Select SUM(n.nota)/SIZE(n.alumno.ciclo.modulos) as notamedia,n.alumno.nombre,n,n.alumno.email FROM Nota AS n WHERE n.alumno.ciclo.idCiclo is :idCiclo GROUP BY n.alumno.idUsuario";
        List<Object[]> listaResultados = null;
        try {
            this.startSession();
            Query query = sesion.createQuery(hql);
            query.setParameter("idCiclo", ciclo);
            listaResultados = query.list();
        } catch (HibernateException he) {
            if (sesion != null) {
                this.handleException(he);
            }
        } finally {
            this.endSession();
        }
        return listaResultados;
    }
}
