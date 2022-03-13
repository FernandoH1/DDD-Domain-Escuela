package domain.maestro;

import co.com.sofka.domain.generic.EventChange;
import domain.maestro.event.DireccionModificada;
import domain.maestro.event.MaestroCreado;

public class MaestroChange extends EventChange {

    public MaestroChange(Maestro maestro) {
        apply((MaestroCreado event)-> {
            maestro.direccion = event.getDireccion();
            maestro.especialidad = event.getEspecialidad();
            maestro.informacionPersonal = event.getInformacionPersonal();
            maestro.utiles = event.getUtiles();
        });

        apply((DireccionModificada event) ->{
            maestro.direccion = event.getDireccion();
        });


    }
}
