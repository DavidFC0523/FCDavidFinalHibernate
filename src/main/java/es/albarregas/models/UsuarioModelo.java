/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.models;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Nota;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gared
 */
public class UsuarioModelo {

    public static String encriptar(String contra) {
        /**Encriptamos la Contraseña en MD5*/
        String contrasenia = contra;
        String encString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encBytes = md.digest(contrasenia.getBytes());
            BigInteger numero = new BigInteger(1, encBytes);
            encString = numero.toString(16);
            while (encString.length() < 32) {
                encString = "0" + encString;
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encString;
    }

    public static List<Alumno> alumnoNotaPonderada(List<Object[]> lista) {
        /**Calculamos la NotaPonderada*/
        String nombre = null;
        String notaMedia = null;
        double notaMediaPonderada;
        double nAlto = 0;
        double nBajo = 0;
        List<Alumno> listaOrdenada = new ArrayList<Alumno>();
        
        for (Object[] x : lista) {
            /**Creamos Objetos Alumnos Para Guardar sus Notas y Nombre*/
            Alumno objNota = new Alumno();
            objNota.setNombre((String) x[1]);
            objNota.setNotaMedia(String.valueOf(x[0]));
            objNota.setEmail(String.valueOf(x[3]));
            Nota nota = (Nota) x[2];
            /**Calculamos su Nota Ponderada*/
            Set<Nota> listnota = (Set<Nota>) nota.getAlumno().getNotas();
            for (Nota indnota : listnota) {
                nAlto = nAlto + (indnota.getModulo().getHoras() * indnota.getNota());
                nBajo = nBajo + indnota.getModulo().getHoras();
            }
            notaMediaPonderada = nAlto / nBajo;
            nAlto = 0;
            nBajo = 0;
            objNota.setNotaMediaPonderada(notaMediaPonderada);
            notaMediaPonderada = 0;
            listaOrdenada.add(objNota);
            
        }
        /**Ordenamos la lista por Nota Ponderada*/
        List<Alumno> listaOrdenadaMPonde = new ArrayList<Alumno>();
        Alumno notaAuxMayor = new Alumno();
        int NumeroRepeticion = listaOrdenada.size();
        for (int i = 0; i < NumeroRepeticion; i++) {
            notaAuxMayor = listaOrdenada.get(0);
            for (Alumno indnota : listaOrdenada) {
                if (notaAuxMayor.getNotaMediaPonderada() <= indnota.getNotaMediaPonderada()) {
                    notaAuxMayor = indnota;
                }
            }
            listaOrdenadaMPonde.add(notaAuxMayor);
            listaOrdenada.remove(notaAuxMayor);
        }
        return listaOrdenadaMPonde;
    }
}
