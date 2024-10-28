package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;

import java.io.IOException;

@WebServlet(name = "SvEditarUsuarios", value = "/SvEditarUsuarios")
public class SvEditarUsuarios extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usu = controladora.traerUsuario(id);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuarioEditar", usu);

        System.out.println("El usuario es: " + usu.getNombreUsuario());
        response.sendRedirect("editarUsuarios.jsp");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreUsuario = request.getParameter("nombreUsuario");
        String contrasenia = request.getParameter("contrasenia");
        String rol = request.getParameter("rol");

        Usuario usu = (Usuario) request.getSession().getAttribute("usuarioEditar");
        usu.setNombreUsuario(nombreUsuario);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);

        controladora.editarUsuario(usu);
        response.sendRedirect("/ClinicaOdontologica_war_exploded/SvUsuarios");

    }
}