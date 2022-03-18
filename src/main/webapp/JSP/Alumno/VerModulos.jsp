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
        <title>Lista Modulos</title>
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
        <!--Navagador-->
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
                            <input class="botones" type="submit" value="CambiarDatosAlumno" name="op">
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
                    <!--Logica para Saber si la Sesion esta Iniciada-->
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
            <!--Ver Modulos del Tutor-->
            <form action ="control" method="POST"> 
                <div class="modal-body">
                    <input type="hidden" name="op"value="EliminarTutor">     
                    <table class="table table-striped" style="width: 500px">
                        <tr>
                            <th>Profesor:</th><th colspan="2">${ColeccionModulo[0][0]}</th>
                        </tr>
                        <tr> 
                            <td style="">Nombre<td>
                            <td style="">Horas<td>
                            <td style="">Familia<td>
                        </tr> 
                        <c:forEach var="modulo" items="${ColeccionModulo[0][1].modulos}">
                            <tr> 
                                <td style="">${modulo.nombre}<td>
                                <td style="">${modulo.horas}<td>
                                <td style="">${modulo.familia.denominacion}<td>
                            </tr>      
                        </c:forEach>
                    </table>
                </div>
            </form>
        </div>
    </div>  
</div>
</div>

<script src="JS/ComprobarCorreo.js"></script>

</body>
</html>
