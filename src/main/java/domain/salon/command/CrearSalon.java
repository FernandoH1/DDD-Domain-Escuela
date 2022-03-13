package domain.salon.command;

import co.com.sofka.domain.generic.Command;
import domain.generic.ClaseId;
import domain.generic.SalonId;
import domain.salon.entity.Articulo;
import domain.salon.value.Capacidad;

import java.util.Set;

public class CrearSalon extends Command {
    private final SalonId salonId;
    private final Articulo articulo;
    private final Capacidad capacidad;
    private final Set<ClaseId> clase;


    public CrearSalon(SalonId salonId, Articulo articulo, Capacidad capacidad, Set<ClaseId> clase) {
        this.salonId = salonId;
        this.articulo = articulo;
        this.capacidad = capacidad;
        this.clase = clase;
    }

    public SalonId getSalonId() {
        return salonId;
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
