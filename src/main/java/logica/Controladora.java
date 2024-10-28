package logica;

import persistencia.ControladoraPersistencia;

import java.util.List;

public class Controladora {

    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();

    public void crearUsuario(String nombreUsuario, String contrasenia, String rol) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContrasenia(contrasenia);
        usuario.setRol(rol);
        controladoraPersistencia.crearUsuario(usuario);
    }

    public List<Usuario> getUsuarios() {
        return controladoraPersistencia.getUsuarios();


    }

    public void borrarUsuario(int id) {
        controladoraPersistencia.borrarUsuario(id);
    }

    public Usuario traerUsuario(int id) {
       return controladoraPersistencia.traerUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
        controladoraPersistencia.editarUsuario(usu);
    }
}
