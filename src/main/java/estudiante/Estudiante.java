package estudiante;

import co.com.sofka.domain.generic.AggregateEvent;
import estudiante.entityStudent.*;
import generic.EstudianteId;


public class Estudiante extends AggregateEvent<EstudianteId> {
    protected EstudianteId estudianteId;
    protected Nombre nombre;
    protected Direccion direccion;
    protected Utiles utiles;
    protected Nota nota;
    protected Falta falta;

    public Estudiante(EstudianteId entityId) {
        super(entityId);
    }

    public Estudiante(EstudianteId entityId, EstudianteId estudianteId, Nombre nombre, Direccion direccion, Utiles utiles, Nota nota, Falta falta) {
        super(entityId);
        this.estudianteId = estudianteId;
        this.nombre = nombre;
        this.direccion = direccion;
        this.utiles = utiles;
        this.nota = nota;
        this.falta = falta;
    }
}
