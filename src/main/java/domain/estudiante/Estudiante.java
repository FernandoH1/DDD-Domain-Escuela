package domain.estudiante;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.estudiante.entity.Falta;
import domain.estudiante.entity.Nota;
import domain.estudiante.entity.Utiles;
import domain.estudiante.event.EstudianteCreado;
import domain.estudiante.event.NombreModificado;
import domain.generic.Direccion;
import domain.generic.EstudianteId;
import domain.generic.Nombre;

import java.util.List;


public class Estudiante extends AggregateEvent<EstudianteId> {
    protected Nombre nombre;
    protected Direccion direccion;
    protected Utiles utiles;
    protected Nota nota;
    protected Falta falta;

    public Estudiante(EstudianteId estudianteId, Nombre nombre, Direccion direccion, Utiles utiles, Nota nota, Falta falta) {
        super(estudianteId);
        appendChange(new EstudianteCreado(nombre,direccion,utiles,nota,falta));
    }

    private Estudiante(EstudianteId estudianteId){
        super(estudianteId);
        subscribe(new EstudianteChange(this));
    }

    public static Estudiante from(EstudianteId estudianteId, List<DomainEvent> events){
        var estudiante = new Estudiante(estudianteId);
        events.forEach(estudiante::applyEvent);
        return estudiante;
    }

    public void cambiarNombre(Nombre nombre){
        appendChange(new NombreModificado(nombre)).apply();
    }
}
