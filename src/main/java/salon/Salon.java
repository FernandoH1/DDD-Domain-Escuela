package salon;

import co.com.sofka.domain.generic.AggregateEvent;
import generic.ClaseId;
import generic.SalonId;
import salon.entity.Articulo;
import salon.valueObject.Capacidad;


public class Salon extends AggregateEvent<SalonId> {
    protected Articulo articulo;
    protected ClaseId claseId;
    protected Capacidad capacidad;


    public Salon(SalonId entityId) {
        super(entityId);
    }
}
