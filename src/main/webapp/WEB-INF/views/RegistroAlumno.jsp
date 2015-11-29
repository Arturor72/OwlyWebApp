<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Owly - Registro</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
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
				<strong>Registrate</strong>
			</div>
		</div>
		<div class="box-white">
			<form method="POST">
				<div class="form-group">
			  		<div class="input-group">
			    		<div class="input-group-addon">
			    			<i class="fa fa-circle"></i>
			    		</div>
			      		<input type="text" class="form-control" id="aluNom" name="aluNom" placeholder="Nombre">
			    	</div>
			  	</div>
			  	<div class="form-group">
				  	<div class="input-group">
				    	<div class="input-group-addon">
				    		<i class="fa fa-circle"></i>
				    	</div>
				      	<input type="text" class="form-control" id="aluApePat" name="aluApePat" placeholder="Apellido Paterno">
				    </div>
				 </div>
				 <div class="form-group">
				  	<div class="input-group">
				    	<div class="input-group-addon">
				    		<i class="fa fa-circle"></i>
				    	</div>
				      	<input type="text" class="form-control" id="aluApeMat" name="aluApeMat" placeholder="Apellido Materno">
				    </div>
				 </div>
				 <div class="form-group">
				  	<div class="input-group">
				    	<div class="input-group-addon">
				    		<i class="fa fa-circle"></i>
				    	</div>
				      	<input type="text" class="form-control" id="aluEda" name="aluEda" placeholder="Edad">
				    </div>
				 </div>
				 <div class="form-group">
				  	<div class="input-group">
				    	<div class="input-group-addon">
				    		<i class="fa fa-circle"></i>
				    	</div>
				      	<input type="text" class="form-control" id="aluDni" name="aluDni" placeholder="Dni">
				    </div>
				 </div>
				<div class="form-group">
				  	<div class="input-group">
				    	<div class="input-group-addon">
				    		<i class="fa fa-circle"></i>
				    	</div>
				      	<input type="text" class="form-control" id="aluUsu" name="aluUsu" placeholder="Usuario">
				    </div>
				 </div>
				 <div class="form-group">
				  	<div class="input-group">
				    	<div class="input-group-addon">
				    		<i class="fa fa-lock"></i>
				    	</div>
				      	<input type="password" class="form-control" id="aluPas" name="aluPas" placeholder="Contraseña">
				    </div>
				  </div>
				<div class="form-group">
				  	<div class="input-group">
				    	<div class="input-group-addon">
				    		<i class="fa fa-envelope-o"></i>
				    	</div>
				      	<input type="text" class="form-control" id="aluEma" name="aluEma" placeholder="Correo">
				    </div>
				</div>
				<div class="form-group">
				  	<div class="input-group">
				    	<div class="input-group-addon">
				    		<i class="fa fa-envelope-o"></i>
				    	</div>
				      	<select class="form-control" name="aluEsp" >
				      	<c:forEach items="${especialidades}" var="especialidad">
				      		<option value="<c:out value="${especialidad.espId}"></c:out> "><c:out value="${especialidad.espDen}"></c:out> </option>
				      	</c:forEach>
				      	
				      	</select>
				    </div>
				</div>
				  <input type="hidden" name="_csrf" value="${_csrf.token}" />	
				  <button type="submit" class="btn btn-default btn-md btn-block">Registrar</button>			  
			</form>
		</div>
		
	</div>

	<script src="<c:url value='/resources/js/jquery.js' />"></script>
    <script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
    <script src="<c:url value='/resources/js/alumno/alumno.js' />"></script>
</body>
</html>