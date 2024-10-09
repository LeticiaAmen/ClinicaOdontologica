package logica;

import persistencia.ControladoraPersistencia;

public class Controladora {

    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();

    public void crearUsuario(String nombreUsuario, String contrasenia, String rol) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContrasenia(contrasenia);
        usuario.setRol(rol);
        controladoraPersistencia.crearUsuario(usuario);
    }

}
