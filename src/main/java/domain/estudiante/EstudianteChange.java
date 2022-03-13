package domain.estudiante;

import co.com.sofka.domain.generic.EventChange;
import domain.estudiante.event.EstudianteCreado;
import domain.estudiante.event.NombreModificado;

public class EstudianteChange extends EventChange {

    public EstudianteChange(Estudiante estudiante) {
        apply((EstudianteCreado event) -> {
            estudiante.nombre = event.getNombre();
            estudiante.direccion = event.getDireccion();
            estudiante.falta = event.getFalta();
            estudiante.nota = event.getNota();
            estudiante.utiles = event.getUtiles();
        });

        apply((NombreModificado event) -> {
            estudiante.nombre = event.getNombre();
        });
    }
}
