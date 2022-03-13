package domain.salon;

import co.com.sofka.domain.generic.EventChange;
import domain.salon.event.CapacidadModificada;
import domain.salon.event.SalonCreado;

public class SalonChange extends EventChange {

    public SalonChange(Salon salon){
        apply((SalonCreado event) -> {
            salon.capacidad = event.getCapacidad();
            salon.articulo = event.getArticulo();
            salon.clase = event.getClase();
        });

        apply((CapacidadModificada event) ->{
            salon.capacidad = event.getCapacidad();
        });
    }
}
