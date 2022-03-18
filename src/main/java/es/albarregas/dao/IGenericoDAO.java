package es.albarregas.dao;



import java.io.Serializable;
import java.util.List;


public interface IGenericoDAO <T> {
     public void insertUpdate(T entidad);
     public <T> List <T> selectAll(Class<T> ClaseEntidad);
     public <T> T selectById(Serializable id, Class<T> claseEntidad);
     public void delete (T entidad);
}