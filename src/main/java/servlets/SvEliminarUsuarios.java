package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica.Controladora;

import java.io.IOException;

@WebServlet(name = "SvEliminarUsuarios", value = "/SvEliminarUsuarios")
public class SvEliminarUsuarios extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        controladora.borrarUsuario(id);
        response.sendRedirect("/ClinicaOdontologica_war_exploded/SvUsuarios");

    }
}