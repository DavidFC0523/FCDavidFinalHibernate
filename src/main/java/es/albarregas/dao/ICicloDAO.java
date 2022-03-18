package es.albarregas.dao;




import es.albarregas.dao.*;
import es.albarregas.beans.Modulo;
import es.albarregas.beans.Usuario;
import java.io.Serializable;
import java.util.List;


public interface ICicloDAO {
    /**Obtenemos los Ciclos que todavia no tienen un tutor asignados*/
    public List<Object[]> getCiclosSinTutor ();
}