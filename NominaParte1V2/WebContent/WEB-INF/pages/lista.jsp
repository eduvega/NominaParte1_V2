<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
    crossorigin="anonymous">
<title>Gestion de Nominas 2.1</title>
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
                      <h1 class="text-center">Gestion de nominas 2.1 </h1>   
                      
                    </div>
            
 
            

                <div class="container ">
                    <h3 class="text-center">Lista de empleados</h3>
                   
<table class="table table-bordered text-center table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>Nombre</th>
                                <th>DNI</th>
                                <th>Sexo</th>
                                <th>Categoría</th>
                                <th>Años</th>
                                <th>Editar</th>
                                
                            </tr>
                        </thead>
                        <tbody>
<c:forEach var="empleado" items="${listaEmpleado}">

                                <tr>
                                    <td>
                                        <c:out value="${empleado.nombre}" />
                                    </td>
                                    <td>
                                        <c:out value="${empleado.dni}" />
                                    </td>
                                    <td>
                                        <c:out value="${empleado.sexo}" />
                                    </td>
                                    <td>
                                        <c:out value="${empleado.anyos}" />
                                    </td>
                                     <td>
                                        <c:out value="${empleado.categoria}" />
                                    </td>
                                    <td>
                                        <a class="btn btn-primary" href="/NominaParte1V2/EmpleadoServlet?accion=editar&dni=${empleado.dni}">Editar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>

                    </table>
       					<a class="btn btn-primary" value="index" href="/NominaParte1V2/EmpleadoServlet"> Volver </a>
                    </div>
      
                   
           

			
                   
</body>
</html>