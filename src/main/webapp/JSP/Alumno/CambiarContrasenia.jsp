<%-- 
    Document   : GestionUsuario
    Created on : 31-dic-2021, 11:53:28
    Author     : gared
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contexto" value="${pageContext.request.contextPath}" scope="application"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <link rel="shortcut icon" href="imagen/icono.png">
        <title>Datos Alumnos</title>
        <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
                integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script> 
         <link rel="stylesheet" href="././CSS/estilo.css">
    </head>
    <body>
        <br><br><br><br><br><br><br>
        <div class="row justify-content-center"">
            <!--Formulario Que se encuentra un alumno al entrar por primera vez-->
            <form action ="./AlumnosControlador" method="POST"> 
                <div class="modal-body">
                    <input type="hidden" name="op"value="CambiarContrasenia"> 
                    <h6>Nombre Completo</h6>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1"><i class="fa fa-user"></i></span>
                        </div>
                        <input type="text" class="form-control" id="Nombre" placeholder="Nombre" aria-label="Username"
                               aria-describedby="basic-addon1" name="nombre" required="required" value=""  maxlength="30">
                    </div>

                    <h6>Apellidos</h6>
                    <div class="input-group mb-3">

                        <div class="input-group-prepend">

                            <span class="input-group-text" id="basic-addon1"><i class="fa fa-user"></i></span>
                        </div>
                        <input type="text" class="form-control" id="Apellidos" placeholder="Apellidos" aria-label="Username"
                               aria-describedby="basic-addon1" name="apellidos" value=""  maxlength="60">
                    </div>
                    <h6>NIF</h6>
                    <div class="input-group mb-3">

                        <div class="input-group-prepend">

                            <span class="input-group-text" id="SpanNIF"></span>
                        </div>
                        <input type="text" class="form-control" id="NIF" placeholder="00000000" aria-label="Username"
                               aria-describedby="basic-addon1" name="dni" value="" required="required"  maxlength="9">
                    </div>
                    <h6>Fecha Nacimiento</h6>
                    <div class="input-group mb-3">

                        <div class="input-group-prepend">

                            <span class="input-group-text" id="SpanNIF"></span>
                        </div>
                        <input type="date" class="form-control" id="NIF" name="fechaNacimiento" required="required" value="2013-10-08">
                    </div>
                    <h6>Genero</h6>
                    <div class="input-group mb-3">

                        <div class="input-group-prepend">

                            <span class="input-group-text" id="SpanNIF"></span>
                        </div>

                        <select name="genero">
                            <option value="Mujer" selected>Mujer</option>
                            <option value="Hombre">Hombre</option>
                            <option value="Otro">Otro</option>
                        </select>                        
                    </div>

                    <h6>Contraseña</h6>
                    <div class="input-group mb-3">

                        <div class="input-group-prepend">

                            <span class="input-group-text" id="basic-addon1"><i class="fa fa-user"></i></span>
                        </div>
                        <input type="password" class="form-control" id="password1" placeholder="Contraseña" aria-label="Username"
                               aria-describedby="basic-addon1" name="password1" required="required">
                    </div>

                    <h6>Contraseña</h6>
                    <div class="input-group mb-3">

                        <div class="input-group-prepend">

                            <span class="input-group-text" id="basic-addon1"><i class="fa fa-user"></i></span>
                        </div>
                        <input type="password" class="form-control" id="password2" placeholder="Contraseña" aria-label="Username"
                               aria-describedby="basic-addon1" name="password2" required="required">
                    </div>



                    <div id="boton" class="modal-footer text-left">

                        <input type="submit" value="Registrarse" id="botonActualizar" class="btn btn-primary" data-dismiss="modal" name="Registrarse" disabled="disabled"> 
                    </div>

                </div>
            </form>
        </div>  
        <script src="JS/ComprobarContrasenia.js"></script>

    </body>
</html>
