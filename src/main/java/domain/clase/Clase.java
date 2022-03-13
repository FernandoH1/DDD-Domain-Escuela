package domain.clase;

import co.com.sofka.domain.generic.DomainEvent;
import domain.clase.event.ClaseCreada;
import domain.clase.event.PuntajeModificado;
import domain.clase.value.Puntaje;
import domain.clase.value.Turno;
import co.com.sofka.domain.generic.AggregateEvent;
import domain.generic.ClaseId;
import domain.generic.EstudianteId;
import domain.generic.MaestroId;

import java.util.List;
import java.util.Set;

public class Clase extends AggregateEvent<ClaseId> {
 protected Set<MaestroId> maestroId;
 protected Set<EstudianteId> estudianteId;
 protected Puntaje puntaje;
 protected Turno turno;

    public Clase(ClaseId claseId, Set<MaestroId> maestroId, Set<EstudianteId> estudianteId, Puntaje puntaje, Turno turno) {
        super(claseId);
        appendChange(new ClaseCreada(maestroId,estudianteId,puntaje,turno)).apply();
    }

    private Clase(ClaseId claseId){
        super(claseId);
        subscribe(new ClaseChange(this));
    }

    public static Clase form(ClaseId claseId, List<DomainEvent> events){
        var clase = new Clase(claseId);
        events.forEach(clase::applyEvent);
        return clase;
    }

    public void cambiarPuntaje(Puntaje puntaje){
        appendChange(new PuntajeModificado(puntaje)).apply();
    }
}
