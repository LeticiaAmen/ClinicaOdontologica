package logica;

import java.util.Date;

public class Secretario extends Persona {
    private int idSecretario;
    private String sector;
    private Usuario unUsuario;

    public Secretario() {
    }

    public Secretario(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, int idSecretario, String sector, Usuario unUsuario) {
        super(dni, nombre, apellido, telefono, direccion, fechaNac);
        this.idSecretario = idSecretario;
        this.sector = sector;
        this.unUsuario = unUsuario;
    }

    public int getIdSecretario() {
        return idSecretario;
    }

    public void setIdSecretario(int idSecretario) {
        this.idSecretario = idSecretario;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }
}
