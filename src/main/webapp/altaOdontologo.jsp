<%@page contentType="text/html" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="componentes/header.jsp"%>
<%@ include file="componentes/bodyprimero.jsp"%>
<h1>Alta Odontólogos</h1>

<form class="user">
    <div class="form-group col">
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="dni"
                   placeholder="DNI">
        </div>
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="nombre"
                   placeholder="Nombre">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="apellido"
                   placeholder="Apellido">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="telefono"
                   placeholder="Teléfono">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="direccion"
                   placeholder="Dirección">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="fechaNacimiento"
                   placeholder="Fecha de Nacimiento">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="especialidad"
                   placeholder="Especialidad">
        </div>

<%--   Acá va a ir lo que respecta a horarios y usuarios     --%>

    </div>

    <a href="" class="btn btn-primary btn-user btn-block">
        Crear Odontólogo
    </a>

</form>
<%@ include file="componentes/bodyfinal.jsp"%>
