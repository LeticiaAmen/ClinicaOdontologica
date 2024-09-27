package logica;

import java.util.Date;

public class Responsable extends Persona{

    private int IdResponsable;
    private String TipoResp;

    public Responsable() {
    }

    public Responsable(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, int idResponsable, String tipoResp) {
        super(dni, nombre, apellido, telefono, direccion, fechaNac);
        IdResponsable = idResponsable;
        TipoResp = tipoResp;
    }

    public int getIdResponsable() {
        return IdResponsable;
    }

    public void setIdResponsable(int idResponsable) {
        IdResponsable = idResponsable;
    }

    public String getTipoResp() {
        return TipoResp;
    }

    public void setTipoResp(String tipoResp) {
        TipoResp = tipoResp;
    }
}
