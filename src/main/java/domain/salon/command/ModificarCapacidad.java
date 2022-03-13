package domain.salon.command;

import co.com.sofka.domain.generic.Command;
import domain.generic.SalonId;
import domain.salon.value.Capacidad;

public class ModificarCapacidad extends Command {
    private final SalonId salonId;
    private final Capacidad capacidad;

    public ModificarCapacidad(SalonId salonId, Capacidad capacidad) {
        this.salonId = salonId;
        this.capacidad = capacidad;
    }

    public SalonId getSalonId(){
        return salonId;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }
}
