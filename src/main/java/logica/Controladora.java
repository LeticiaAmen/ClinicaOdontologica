package logica;

import persistencia.ControladoraPersistencia;

import java.util.ArrayList;
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

    public boolean comprobarIngreso(String usuario, String contrasenia) {
        List<Usuario> usuarios = controladoraPersistencia.getUsuarios();
        for (Usuario usu : usuarios) {
            if (usu.getNombreUsuario().equals(usuario) && usu.getContrasenia().equals(contrasenia)) {
                return true; //usuario encontrado
            }
        }
        return false; // no se encontró ningún usuario con las credenciales
    }


}
