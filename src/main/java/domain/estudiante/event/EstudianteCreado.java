package domain.estudiante.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.estudiante.entity.Falta;
import domain.estudiante.entity.Nota;
import domain.estudiante.entity.Utiles;
import domain.generic.Direccion;
import domain.generic.Nombre;

public class EstudianteCreado extends DomainEvent {
    private final Nombre nombre;
    private final Direccion direccion;
    private final Utiles utiles;
    private final Nota nota;
    private final Falta falta;


    public EstudianteCreado(Nombre nombre, Direccion direccion, Utiles utiles, Nota nota, Falta falta) {
        super("doamin.estudiante.estudianteCreado");
        this.nombre = nombre;
        this.direccion = direccion;
        this.utiles = utiles;
        this.nota = nota;
        this.falta = falta;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Utiles getUtiles() {
        return utiles;
    }

    public Nota getNota() {
        return nota;
    }

    public Falta getFalta() {
        return falta;
    }
}
