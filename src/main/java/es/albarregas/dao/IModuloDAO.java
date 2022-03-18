package es.albarregas.dao;




import es.albarregas.dao.*;
import es.albarregas.beans.Modulo;
import es.albarregas.beans.Usuario;
import java.io.Serializable;
import java.util.List;


public interface IModuloDAO {
     /**Obtenemos los Modulos de un Ciclo especifico*/    
     public List<Object[]> moduloPorCiclo (String idCiclo);    
}