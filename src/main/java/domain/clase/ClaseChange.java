package domain.clase;

import co.com.sofka.domain.generic.EventChange;
import domain.clase.event.ClaseCreada;
import domain.clase.event.PuntajeModificado;
import domain.salon.event.CapacidadModificada;

public class ClaseChange extends EventChange {

    public ClaseChange(Clase clase){
        apply((ClaseCreada event) ->{
            clase.estudianteId = event.getEstudianteId();
            clase.maestroId = event.getMaestroId();
            clase.puntaje = event.getPuntaje();
            clase.turno = event.getTurno();
        });

        apply((PuntajeModificado event) ->{
            clase.puntaje = event.getPuntaje();
        });
    }
}
