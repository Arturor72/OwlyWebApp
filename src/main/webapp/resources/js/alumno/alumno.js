/**
 * 
 */
var main = function(){
	verifyUser();
	getTemas();
	getTemasOnChange();
}

function verifyUser(){
	$("#aluUsu").focusout(function(){
		var username=$("#aluUsu").val();
		var token = $("input[name='_csrf']").val();
		var header = $("meta[name='_csrf_header']").attr("content");
		console.log(username);
		console.log(token);
		console.log(header);
		sendUsername(username,token, header)
	});	
}

function sendUsername(username, tokens, headers){
	var mydata={"user":username}
	var request=$.ajax({
		contentType: 'application/json',
		url: "/OwlyWebApp/registro/getUsername",
		method:"POST",
		data:JSON.stringify(mydata),
		beforeSend: function( xhr ) {
			  xhr.setRequestHeader(headers, tokens);
		  }
	});
	request.done(function(msg){
		console.log(msg);
		if(msg===""){
			$("#aluUsu").css("border-color","");
			console.log(msg);
			console.log(msg);
		}else{
			$("#aluUsu").css("border-color","red");
		}
		
	});
}
function getTemas(){
	var idCurso=$("#cursosEjercicio").val();
	var token = $("input[name='_csrf']").val();
	var header = $("meta[name='_csrf_header']").attr("content");
	console.log(idCurso);
	console.log(token);
	console.log(header);
	sendCursoId(idCurso,token, header)
	
}
function getTemasOnChange(){
	$("#cursosEjercicio").change(function(){
		getTemas();
	});
}

function sendCursoId(idCurso, tokens, headers){
	var mydata={"cursoId": idCurso}
	var request=$.ajax({
		contentType: 'application/json',
		url: "/OwlyWebApp/alumno/sendCursoId",
		method:"POST",
		data:JSON.stringify(mydata),
		beforeSend: function( xhr ) {
			  xhr.setRequestHeader(headers, tokens);
		  }
	});
	request.done(function(msg){
		console.log(msg);
		if(msg===""){
			// Here manage when no exists temas
		}else{
			var objs = JSON.parse(msg);
			console.log(objs);
			var addTemas="";
			for (var i = 0; i < objs.length; i++) {
				addTemas=addTemas+"<option value=\\" +objs[i].temId + "\\ >"+objs[i].temDes+" </option>";
				console.log(objs[i].temId);
			}
		
			$("#temasEjercicio").html(addTemas);
		}
		
	});
	
}
$("document").ready(main);

