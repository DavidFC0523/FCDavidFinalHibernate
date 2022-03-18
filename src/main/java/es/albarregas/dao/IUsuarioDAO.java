package es.albarregas.dao;




import es.albarregas.dao.*;
import es.albarregas.beans.Modulo;
import es.albarregas.beans.Usuario;
import java.io.Serializable;
import java.util.List;


public interface IUsuarioDAO {
    /**Comprobamos si el email y password enviados son correctos*/
    public Usuario comprobarLogin (String email, String password);
    /**Comprobamos si el email existe en la BSDD*/
    public List<Object[]> comprobarEmail (String email);
    /**Devolvemos una lista de Tutores Sin Alumnos*/
    public List<Object[]> getTutorSinAlumno();
    /**Obtenemos la Lista de Profesores y Alumnos*/
    public List<Object[]> listaProfesorAlumno();
    /**Obtenemos la Lista de Alumnos de un Profesor Especifico*/
    public List<Object[]> listaAlumnoPorProfesor(String ciclo);
    /**Devolvemos las Notas de los Alumnos de un Ciclo*/ 
    public List<Usuario> listaAlumnoNotas(String ciclo);
    /**Devolvemos una Lista ordenada por Media*/
    public List<Object[]> listaUsuarioNotaMedia(String ciclo);
    
    
    
    
    
}