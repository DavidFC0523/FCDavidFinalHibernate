
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <link rel="shortcut icon" href="imagen/icono.png">
        <title>PaginaPrincipal</title>
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
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">PCZONE</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <ul class="navbar-nav mr-auto">  
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="modal" data-target="#exampleModal2" href="#">Iniciar Sesión</a>
                                </li>
                        <li>
                        </li>
                    </ul>
                </form>
            </div>
        </nav>

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
     
        <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Inicio Sesion</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <!--Iniciar Sesion-->
                    <form action="././LoginControlador" method="POST">

                        <div class="modal-body">
                            <div class="alert alert-primary alert-dismissible fade show text-left" role="alert">
                                <strong>Info!</strong> Introduzca sus credenciales para poder acceder a la aplicacion.
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <h6>Email</h6>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">

                                    <span class="input-group-text" id="basic-addon1"><i class="fa fa-envelope"></i></span>
                                </div>
                                <input type="email" id="Email" class="form-control" placeholder="Correo Electrónico" aria-label="Username"
                                       aria-describedby="basic-addon1" name="Email">
                            </div>
                            <h6>Contraseña</h6>
                            <div class="input-group mb-3">

                                <div class="input-group-prepend">

                                    <span class="input-group-text" id="basic-addon1"><i class="fa fa-user"></i></span>
                                </div>
                                <input type="password" id="Contrasenia" class="form-control" placeholder="Contraseña" aria-label="Username"
                                       aria-describedby="basic-addon1" name="Contrasenia">
                            </div>
                        </div>
                        <div id="boton" class="modal-footer text-left">
                            <input type="submit" value="Iniciar Sesion" id="InicioSesion" class="btn btn-primary" name="InicioSesion"/>
                        </div>
                    </form> 
                </div>
            </div>
        </div>
    </body>
</html>