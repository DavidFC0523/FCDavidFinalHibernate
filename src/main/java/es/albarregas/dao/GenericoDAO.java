package es.albarregas.dao;

import java.io.Serializable;

import es.albarregas.persistencia.HibernateUtil;


import java.util.List;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;


public class GenericoDAO <T> implements IGenericoDAO {
protected Session sesion;
   

    protected void startSession(){
    sesion = HibernateUtil.getSessionFactory().openSession();
    sesion.getTransaction().begin();
    }
     protected void endSession(){
    if (sesion.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)){
        sesion.getTransaction().commit();
        sesion.close();
    }
}   
    
    protected void handleException(HibernateException he) throws HibernateException{
       sesion.getTransaction().rollback();
       //Lanzar la excepcion
    }
    
    /**
     *
     * @param entidad
     */
    
   
   
    public List selectAll(Class ClaseEntidad) {
        List<Object> listado = null;
        try {
             this.startSession();
            listado = sesion.createQuery(" from "+ClaseEntidad.getSimpleName()).list();
           // sesion.getTransaction().commit();
        } catch(HibernateException he){
            
            System.out.println("ERRROOOOOOOOOR\n" +
"            System.out.println(\"ERRROO");
            if(sesion != null){
                 this.handleException(he);
            }
        } finally {
            
                this.endSession();
            
        }
        return listado;
    }
    public Object selectById(Serializable id, Class claseEntidad) {
       T objetoRecuperado = null;
        try {
            this.startSession();
            objetoRecuperado = (T)sesion.get(claseEntidad, id);
          //  sesion.getTransaction().commit();
        } catch(HibernateException he){
            if(sesion != null){
                this.handleException(he);
            }
        } finally {
           
               this.endSession();
            
        }
        return objetoRecuperado;
    }

 
     public void delete(Object entidad) {
        try {
            this.startSession();
            sesion.delete(entidad);
            //sesion.getTransaction().commit();
        } catch(HibernateException he){
            if(sesion != null){
               this.handleException(he);
            }
        } finally {
                
                this.endSession();
            
        }
    }
     
    public void insertUpdate(Object entidad) {
      
        try {
            this.startSession();
            sesion.saveOrUpdate(entidad);
            sesion.flush();
         //   sesion.getTransaction().commit();
        } catch(HibernateException he){
            if(sesion != null){
                this.handleException(he);
            }
        } finally {
                this.endSession();
            
        }
    }


    

   

   
 
}
