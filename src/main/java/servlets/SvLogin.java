package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica.Controladora;

import java.io.IOException;

@WebServlet(name = "SvLogin", value = "/SvLogin")
public class SvLogin extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");

        boolean validacion = false;
        validacion = controladora.comprobarIngreso(usuario, contrasenia);
        if (validacion) {
            HttpSession session = request.getSession(true); //Creamos la sesión
            session.setAttribute("usuario", usuario);
            response.sendRedirect("index.jsp");
        }else {
            response.sendRedirect("loginError.jsp");
        }

    }
}