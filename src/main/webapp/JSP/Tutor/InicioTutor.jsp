<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contexto" value="${pageContext.request.contextPath}" scope="application"/>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <link rel="shortcut icon" href="imagen/icono.png">
        <title>Inicio Tutor</title>
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
        <link rel="stylesheet" type="text/css" href="css/style_index.css">
        <link rel="stylesheet" type="text/css" href="css/sidebars.css">
        <style type="text/css">

        </style>
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
                    <!--Redireccion-->
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <input class="botones" type="submit" value="CambiarDatosTutor" name="op">
                        </li>
                        <li class="nav-item">
                            <input class="botones" type="submit" value="AltaAlumno" name="op">
                        </li>

                        <li class="nav-item">
                            <input class="botones" type="submit" value="EliminarAlumno" name="op">
                        </li>

                        <li class="nav-item">
                            <input class="botones" type="submit" value="NotasExamenes" name="op">
                        </li>

                        <li class="nav-item">
                            <input class="botones" type="submit" value="ListarAlumno" name="op">
                        </li>
                    </ul>

                </form>
                <ul class="navbar-nav mr-auto">
                    <form action="ReiniciarControlador" method="POST">
                        <li class="nav-item">
                            <input class="cerrarSesion" type="submit" value="Cerrar Sesion" name="op">
                        </li>
                    </form>
                    <!--Logica para ver si existe la sesion-->
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
        <!--Mostrar los diferentes mensajes de error-->
        <c:choose>
            <c:when test="${mensajeErr != null}">  
                <h3 style="color: red">${mensajeErr}</h3>
            </c:when>
        </c:choose>
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner" id="carrusel"> 
                <div class="carousel-item active">
                    <img class="d-block w-100" id="img" src="./IMAGENES/1.png" alt="First slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" id="img" src="./IMAGENES/2.jpg" alt="Second slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" id="img" src="./IMAGENES/3.jpg" alt="Third slide">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </body>
</html>
