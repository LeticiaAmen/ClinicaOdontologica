package logica;

import persistencia.ControladoraPersistencia;

public class Controladora {

    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();

    public void crearUsuario(int id, String nombreUsuario, String contrasenia, String rol) {
        Usuario usuario = new Usuario(id, nombreUsuario, contrasenia, rol);
        controladoraPersistencia.crearUsuario(usuario);
    }

}
