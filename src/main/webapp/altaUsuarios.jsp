<%@page contentType="text/html" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="componentes/header.jsp"%>
<%@ include file="componentes/bodyprimero.jsp"%>
<h1>Alta Usuarios</h1>
<p>Este es el apartado para dar de alta a los diferentes usuarios del sistema. </p>

<form class="user" action="SvUsuarios" method="post">
    <div class="form-group col">
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="nombreUsuario" name="nombreUsuario"
                   placeholder="Nombre de Usuario">
        </div>
        <div class="col-sm-6 mb-3 ">
            <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                   placeholder="Contraseña">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="rol" name="rol"
                   placeholder="Rol">
        </div>

    </div>

    <button class="btn btn-primary btn-user btn-block" type="submit">
        Crear Usuario
    </button>

</form>
<%@ include file="componentes/bodyfinal.jsp"%>
