/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.models;

import es.albarregas.beans.Usuario;
import java.io.IOException;
import javax.servlet.http.Part;


//Este Metodo me lo ha enseñado Manuel ya que el dia que se explico el tratamiento de Imagenes yo falte y no sabia como se realizaba
public class AvatarModelo {
     public static String subirAvatar(Part filePart, String dirImagen, Usuario usuario) throws IOException {
        String resultado = "";
        StringBuilder nombreFichero = new StringBuilder();
        String filePath = null;
        if (filePart.getName().length() != 0) {
            // Comprobamos que sea del formato adecuado
            if (filePart.getContentType().equals("image/png") || filePart.getContentType().equals("image/jpeg")) {
                // Comprobamos que tenga el tamaño permitido
                if (filePart.getSize() < 1024000) {
                    // Obtenemos la extensión
                    String extension = filePart.getContentType().equals("image/png")? ".png" : ".jpg";
                    nombreFichero.append("AvatarUsuario").append(usuario.getIdUsuario()).append(extension);
                    filePath = dirImagen + nombreFichero.toString();
                    filePart.write(filePath);
                    resultado = nombreFichero.toString();

                } else { 
                    resultado = "La imagen es mas pesada de lo permitido";
                }
            } else {
                resultado = "avatar.png";
            }
        } else {
             resultado = "El campo avatar es obligatorio";
        }
        return resultado;
    }
}
