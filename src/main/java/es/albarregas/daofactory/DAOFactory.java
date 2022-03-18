package es.albarregas.daofactory;


import es.albarregas.dao.ICicloDAO;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IModuloDAO;

import es.albarregas.dao.IUsuarioDAO;

public abstract class DAOFactory {

    

    public abstract IGenericoDAO getGenericoDAO();
    public abstract IUsuarioDAO getUsuarioDAO();
    public abstract ICicloDAO getCicloDAO();
    public abstract IModuloDAO getModuloDAO();
    public static DAOFactory getDAOFactory() {
        DAOFactory daof = null;

        daof = new MySQLDAOFactory();

        return daof;
    }

}
