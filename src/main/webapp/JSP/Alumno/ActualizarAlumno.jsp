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
        <title>Actualizar Alumno</title>
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
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <form class="form-inline my-2 my-lg-0" action="././Redireccionar" method="POST">
                    <ul class="navbar-nav mr-auto">
                        <!--Redireccion-->
                        <li class="nav-item">
                            <input class="botones" type="submit" value="CambiarDatosAlumno" name="op" >
                        </li>

                        <li class="nav-item">
                            <input class="botones" type="submit" value="VerNotas" name="op">
                        </li>
                        <li class="nav-item">
                            <input class="botones" type="submit" value="VerModulosAlumno" name="op">
                        </li>
                    </ul>
                </form>
                <ul class="navbar-nav mr-auto">
                    <form action="ReiniciarControlador" method="POST">
                        <li class="nav-item">
                            <input class="cerrarSesion" type="submit" value="Cerrar Sesion" name="op">
                        </li>
                    </form>
                    <!--Logica para saber si ha iniciado Sesion-->
                    <c:choose><c:when test="${usuario != null}">  
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="modal" data-target="#exampleModal2" href="#"> <p>${usuario.nombre}</p></a>
                            </li> 
                            <c:choose><c:when test="${usuario.avatar != null}">  
                                    <li class="nav-item">
                                        <img src="${contexto}/IMAGENES/AVATARES/${usuario.avatar}" width="50px"/>
                                    </li> 
                                </c:when>
                            </c:choose> 
                        </c:when>
                    </c:choose> 
                </ul>
                </form>
            </div>
        </nav>
    <body>
        <div class="row justify-content-center">
            <!--Formulario para Actualizar Alumnor-->
            <form action ="AvatarAlumno" method="POST" enctype="multipart/form-data"> 
                <div class="modal-body">
                    <input type="hidden" name="op"value="AddTutor">     
                    <h6>Nombre Completo</h6>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">

                            <span class="input-group-text" id="basic-addon1"><i class="fa fa-user"></i></span>
                        </div>
                        <input type="text" class="form-control" id="Nombre" placeholder="Nombre" aria-label="Username"
                               aria-describedby="basic-addon1" name="nombre" required="required" value="${usuario.nombre}"  maxlength="30">
                    </div>
                    <h6>Apellidos</h6>
                    <div class="input-group mb-3">

                        <div class="input-group-prepend">

                            <span class="input-group-text" id="basic-addon1"><i class="fa fa-user"></i></span>
                        </div>
                        <input type="text" class="form-control" id="Apellidos" placeholder="Apellidos" aria-label="Username"
                               aria-describedby="basic-addon1" name="apellidos" required="required" value="${usuario.apellidos}"  maxlength="60">
                    </div>
                    <h6>NIF</h6>
                    <div class="input-group mb-3">

                        <div class="input-group-prepend">

                            <span class="input-group-text" id="SpanNIF"></span>
                        </div>
                        <input type="text" class="form-control" id="NIF" placeholder="00000000" aria-label="Username"
                               aria-describedby="basic-addon1" name="dni" value="${usuario.dni}" required="required"  maxlength="9">
                    </div>

                    <h6>Email</h6>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">

                            <span class="input-group-text" id="SpanEmail"></span>
                        </div>
                        <input type="email" id="Email" class="form-control" placeholder="Correo Electrónico" aria-label="Username"
                               aria-describedby="basic-addon1" name="email" required="required" value="${usuario.email}"  maxlength="60">
                    </div>


                    <h6>Avatar</h6>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">

                            <span class="input-group-text" id="SpanEmail"></span>
                        </div>
                        <input type="file" name="avatar" id="file__avatar">

                        <div>
                            <img id="avatar__img"  width="100px"/>
                        </div>
                    </div>
                    <div id="boton" class="modal-footer text-left">

                        <input type="submit" value="Actualizar" id="registrar" class="btn btn-primary" data-dismiss="modal" name="Registrarse"> 
                    </div>
                </div>
            </form>
            <form action ="AlumnosControlador" method="POST"> 
                <h2>Cambiar Contraseña</h2>
                <div class="modal-body" width="400px">
                    <input type="hidden" name="op"value="CambiarContrasenia">     
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
                        <input type="submit" value="Actualizar" id="botonActualizar" class="btn btn-primary" data-dismiss="modal" name="Registrarse" disabled="disabled"> 
                    </div>

                </div>
            </form>      
        </div>  
    </div>
</div>
<script src="JS/ComprobarContrasenia.js"></script>
<script src="JS/ComprobarCorreo.js"></script>
<script src="JS/Avatar.js"></script>
</body>
</html>
