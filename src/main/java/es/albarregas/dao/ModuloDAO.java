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

public class ModuloDAO extends GenericoDAO implements IModuloDAO {

    DAOFactory daof = DAOFactory.getDAOFactory();
    IGenericoDAO pdao = daof.getGenericoDAO();

    @Override
    public List<Object[]> moduloPorCiclo(String idCiclo) {
        String hql = "Select t.nombre ,c FROM Ciclo AS c LEFT JOIN Tutor AS t ON c.idCiclo = t.ciclo.idCiclo WHERE t.ciclo.idCiclo is :idCiclo";
        List<Object[]> listaResultados = null;
        try {
            this.startSession();
            Query query = sesion.createQuery(hql);
            query.setParameter("idCiclo", idCiclo);
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
