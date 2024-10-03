package logica;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Responsable extends Persona{


    private String TipoResp;

    public Responsable() {
    }

    public Responsable(int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, String tipoResp) {
        super(id, dni, nombre, apellido, telefono, direccion, fechaNac);
        TipoResp = tipoResp;
    }

    public String getTipoResp() {
        return TipoResp;
    }

    public void setTipoResp(String tipoResp) {
        TipoResp = tipoResp;
    }
}
