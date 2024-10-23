package logica;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTurno;
    @Temporal(TemporalType.DATE)
    private Date fechaTurno;
    private String horaTurno;
    private String afeccion;

    @ManyToOne
    @JoinColumn(name = "idOdonto")
    private Odontologo odonto;

    @ManyToOne
    @JoinColumn(name = "idPacien")
    private Paciente pacien;

    public Turno() {
    }

    public Turno(int idTurno, Date fechaTurno, String horaTurno, String afeccion) {
        this.idTurno = idTurno;
        this.fechaTurno = fechaTurno;
        this.horaTurno = horaTurno;
        this.afeccion = afeccion;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public Date getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(Date fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public String getHoraTurno() {
        return horaTurno;
    }

    public void setHoraTurno(String horaTurno) {
        this.horaTurno = horaTurno;
    }

    public String getAfeccion() {
        return afeccion;
    }

    public void setAfeccion(String afeccion) {
        this.afeccion = afeccion;
    }
}
