package domain.salon.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.salon.value.Capacidad;
import domain.generic.ClaseId;
import domain.salon.entity.Articulo;

import java.util.Set;

public class SalonCreado extends DomainEvent {
    private final Articulo articulo;
    private final Capacidad capacidad;
    private final Set<ClaseId> clase;


    public SalonCreado(Articulo articulo, Capacidad capacidad, Set<ClaseId> clase) {
        super("domain.salon.saloncreado");
        this.articulo = articulo;
        this.capacidad = capacidad;
        this.clase = clase;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }

    public Set<ClaseId> getClase() {
        return clase;
    }
}
