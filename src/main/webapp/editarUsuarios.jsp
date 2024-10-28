<%@ page import="logica.Usuario" %>
<%@page contentType="text/html" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="componentes/header.jsp"%>
<%@ include file="componentes/bodyprimero.jsp"%>
<h1>Editar Usuarios</h1>
<p>Este es el apartado para modificar un usuario del sistema. </p>

<% Usuario usu = (Usuario) request.getSession().getAttribute("usuarioEditar"); %>

<form class="user" action="SvEditarUsuarios" method="post">
    <div class="form-group col">
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="nombreUsuario" name="nombreUsuario"
                   placeholder="Nombre de Usuario" value="<%=usu.getNombreUsuario()%>">
        </div>
        <div class="col-sm-6 mb-3 ">
            <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                   placeholder="Contraseña" value="<%=usu.getContrasenia()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="rol" name="rol"
                   placeholder="Rol" value="<%=usu.getRol()%>">
        </div>

    </div>

    <button class="btn btn-primary btn-user btn-block" type="submit">
        Guardar modificación
    </button>

</form>
<%@ include file="componentes/bodyfinal.jsp"%>
