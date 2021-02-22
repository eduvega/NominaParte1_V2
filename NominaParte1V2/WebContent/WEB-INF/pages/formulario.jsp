<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Gestion de Nominas 2.1</title>
            <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        </head>

        <body>
               
                    <div class="container">
                      <h1 class="text-center">Gestión de nominas 2.1 </h1>   
                    </div>
                    
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <h2>Editar empleado</h2>

                        

						<form action="/NominaParte1V2/EmpleadoServlet?accion=editar" method="post">
							<fieldset class="form-group">
	                            <label>Nombre</label> <input name="nombre" type="text" value="<c:out value='${empleado.nombre}' />" class="form-control"  required="required">
	                        </fieldset>
	
							<fieldset class="form-group">
	                            <label>DNI</label> <input name="dni" readonly type="text" value="<c:out value='${empleado.dni}' />" class="form-control"  required="required">
	                        </fieldset>
	                        
	                        <fieldset class="form-group">
	                            <label>Sexo</label> <input name="sexo" type="text" value="<c:out value='${empleado.sexo}' />" class="form-control" required="required">
	                        </fieldset>
	
	                        <fieldset class="form-group">
	                            <label>Categoría</label> <input name="categoria" type="text" value="<c:out value='${empleado.categoria}' />" class="form-control" >
	                        </fieldset>
	
	                        <fieldset class="form-group">
	                            <label>Años</label> <input name="anyos" type="text" value="<c:out value='${empleado.anyos}' />" class="form-control" >
	                        </fieldset>
	
	                        <button type="submit" class="btn btn-success">Guardar</button>
						</form>

                        
                        
                    </div>
                </div>
            </div>
        </body>

        </html>