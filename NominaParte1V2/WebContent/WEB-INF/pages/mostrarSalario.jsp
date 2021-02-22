<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
    crossorigin="anonymous">
<title>Gestion de nominas 2.1</title>

<style>
h1{
justify-content:flex end;
font-size:52px;
color:#6061b1;
text-decoration: underline;
}
</style>
</head>
<body>
<div class="container">
			<h1 class="text-center">Gestion de nominas 2.1</h1>   
		</div>
<div class="container mt-5">

	
            <form
                action="/NominaParte1V2/EmpleadoServlet?accion=salario"
                method="post">
                <div class="form-group row">
                    <label for="dni"
                        class="text-white col-xl-1 col-md-1 col-sm-1 col-form-label">Dni</label>
                    <div class="col-xl-8 col-md-8 col-sm-6">
                        <input type="text" name="dni" required placeholder="Dni válido"
                            class="form-control">
                    </div>
                    <div class="col-xl-2 col-md-2 col-sm-2">
                        <button class="btn btn-warning text-body" type="submit"><i class="fas fa-share"></i>&nbsp;Enviar</button>
                    </div>
                </div>
            </form>
            <table class="table table-striped table-dark table-bordered">
                <thead class="thead-light text-dark modal-body">
                    <tr class="lead text-center">
                        <th>Dni</th>
                        <th>Sueldo&nbsp;<i class="fas fa-euro-sign"></i></th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="lead text-center">
                        <th>${dni}</th>
                        <th>${sueldo}</th>
                    </tr>
                </tbody>
            </table>
            
     
		 		<a class="btn btn-primary" value="inicio" href="/NominaParte1V2/EmpleadoServlet"> Volver </a>
	
        </div>
</body>
</html>