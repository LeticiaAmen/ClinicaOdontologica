<%@ page import="logica.Usuario" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="componentes/header.jsp"%>
<%@ include file="componentes/bodyprimero.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Usuarios</h1>
    <p class="mb-4">A continuación podrá visualizar la lista completa de usuarios</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Rol</th>
                        <th style="width: 210px">Acción</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Rol</th>
                        <th style="width: 210px">Acción</th>
                    </tr>
                    </tfoot>
                    <%
                        List<Usuario> listaUsuarios = (List<Usuario>) request.getSession().getAttribute("listaUsuarios");
                    %>
                    <tbody>
                    <% for(Usuario usu : listaUsuarios){%>
                    <tr>
                        <td id="idUsuario"><%=usu.getIdUsuario()%></td>
                        <td><%=usu.getNombreUsuario()%></td>
                        <td><%=usu.getRol()%></td>

                        <td style="display: flex; width: 230px;">
                            <form name="eliminar" action="SvEliminarUsuarios" method="post"> <%-- Esto es para mandar el código al servlet  --%>
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px; ">
                                    <i class="fas fa-trash-alt"></i>Eliminar
                                </button>
                                <input type="hidden" name="id" value="<%=usu.getIdUsuario()%>"><%--  esto es para mandar el id al servlet   --%>
                            </form>

                            <form name="editar" action="SvEditarUsuarios" method="get"> <%-- Esto es para mandar el código al servlet  --%>
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                    <i class="fas fa-pencil-alt"></i> Editar
                                </button>
                                <input type="hidden" name="id" value="<%=usu.getIdUsuario()%>"> <%--  esto es para mandar el id al servlet   --%>
                            </form>
                        </td>
                    </tr>

                    <% }%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->



<%@ include file="componentes/bodyfinal.jsp"%>