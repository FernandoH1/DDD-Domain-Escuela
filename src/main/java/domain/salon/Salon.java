package domain.salon;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.generic.SalonId;
import domain.salon.entity.Articulo;
import domain.salon.event.CapacidadModificada;
import domain.salon.event.SalonCreado;
import domain.salon.value.Capacidad;
import domain.generic.ClaseId;

import java.util.List;
import java.util.Set;


public class Salon extends AggregateEvent<SalonId> {
    protected Articulo articulo;
    protected Capacidad capacidad;
    protected Set<ClaseId> clase;

    public Salon(SalonId salonId, Articulo articulo, Capacidad capacidad, Set<ClaseId> clase) {
        super(salonId);
        appendChange(new SalonCreado(articulo,capacidad,clase)).apply();
    }

    private Salon(SalonId salonId){
        super(salonId);
        subscribe(new SalonChange(this));
    }

    public static Salon from(SalonId salonId, List<DomainEvent> events){
        var salon = new Salon(salonId);
        events.forEach(salon::applyEvent);
        return salon;
    }

    public void cambiarCapacidad(Capacidad capacidad){
        appendChange(new CapacidadModificada(capacidad)).apply();
    }

}
