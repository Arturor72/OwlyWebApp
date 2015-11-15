<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Owly - Ingresa</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css'/>">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>
	<div class="box">
		<div class="row vertical-centered-text">
			<div class="col-lg-6 col-sm-6">
				<h3 class="mg-2"><a href="index.html">Owly</a></h3>
			</div>
			<div class="col-lg-6 col-sm-6 text-right ">
				<strong>Ingresar</strong> / <a href="registro.html">Registrate</a>
			</div>
		</div>
		<div class="box-white">
			<form name='loginForm'
		    action="<c:url value='j_spring_security_check' />" method='POST'>
			  <div class="form-group">
			  	<div class="input-group">
			    	<div class="input-group-addon">
			    		<i class="fa fa-user"></i>
			    	</div>
			      	<input type="text" class="form-control" id="exampleInputEmail1" placeholder="Usuario" name="username">
			    </div>
			  </div>
			  <div class="form-group">
			  	<div class="input-group">
			    	<div class="input-group-addon">
			    		<i class="fa fa-lock"></i>
			    	</div>
			      	<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Contraseña" name="password">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-6">
			      <div class="checkbox">
			        <label>
			          <input type="checkbox"> Recordar contraseña
			        </label>
			      </div>
			    </div>
			  </div>
			  <button type="submit" class="btn btn-default btn-md btn-block">Ingresar</button>
			  <input type="hidden" name="_csrf" value="${_csrf.token}" />			  
			</form>
		</div>
		<div class="row">
			<div class="col-lg-offset-6 col-lg-6 text-right">
				<a href="">¿Olvidaste tu contraseña?</a>
			</div>
		</div>
	</div>



    <script src="<c:url value='/resources/js/jquery.js' />"></script>
    <script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
</body>
</html>