package domain.clase.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.clase.value.Puntaje;

public class PuntajeModificado extends DomainEvent {
    private final Puntaje puntaje;


    public PuntajeModificado(Puntaje puntaje) {
        super("domain.clase.puntajemodificado");
        this.puntaje = puntaje;
    }

    public Puntaje getPuntaje() {
        return puntaje;
    }
}
