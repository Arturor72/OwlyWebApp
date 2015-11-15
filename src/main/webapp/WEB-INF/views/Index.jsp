<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Owly</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/sb-admin.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/font-awesome/css/font-awesome.min.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/simple-sidebar.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/common.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/inicio.css'/>">

    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather' rel='stylesheet' type='text/css'>
</head>

<body>

    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="index.html" class="navbar-brand" id="menu-toggle"><img class="vertical-centered-text" src="<c:url value='/resources/img/logo.jpg'/>" alt=""></a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="login.html">Ingresar</a>
            </li>
            <li>
                <a href="registro.html">Registrarse</a>
            </li>            
          </ul>
        </div>
      </div>
    </nav>
    <section class="hero-img">
        <div class="container">
            <div class="row text-center">
                <div class="col-sm-12">
                    <img class="logo pb-3" src="<c:url value='/resources/img/logo.jpg'/>" alt="">
                </div>
            </div>
            <div class="row text-center">
                <div class="col-sm-6">
                    <img class="img-circle" src="<c:url value='/resources/img/estudiante-universidad.jpg' />" alt="">
                    <h2 class="txt-turquesa">De estudiantes</h2>
                    <a href="p-inicio.html" class="btn btn-default btn-turquesa dropdown-toggle">Postula</a>
                </div>
                <div class="col-sm-6">
                    <img class="img-circle" src="<c:url value='/resources/img/estudiante-secundaria.jpg' />" alt="">
                    <h2 class="txt-rosado">Para estudiantes</h2>
                    <a href="e-inicio.html" class="btn btn-default btn-rosa dropdown-toggle">Ingresa</a>
                </div>
            </div>
        </div>
    </section>

    <script src="<c:url value='/resources/js/jquery.js' />"></script>
    <script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
</body>
</html>
