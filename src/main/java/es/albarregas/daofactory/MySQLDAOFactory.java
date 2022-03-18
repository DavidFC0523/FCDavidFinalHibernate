package es.albarregas.daofactory;


import es.albarregas.dao.CicloDAO;
import es.albarregas.dao.GenericoDAO;
import es.albarregas.dao.ICicloDAO;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IModuloDAO;

import es.albarregas.dao.IUsuarioDAO;
import es.albarregas.dao.ModuloDAO;

import es.albarregas.dao.UsuarioDAO;


public class MySQLDAOFactory extends DAOFactory{

    @Override
    public IGenericoDAO getGenericoDAO() {
        return new GenericoDAO();
    }

  @Override
    public IUsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO();
    }

    @Override
    public ICicloDAO getCicloDAO() {
        return new CicloDAO();
    }

    @Override
    public IModuloDAO getModuloDAO() {
       
        return new ModuloDAO();
    }
    
   

  
}
