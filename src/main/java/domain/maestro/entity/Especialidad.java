package domain.maestro.entity;

import co.com.sofka.domain.generic.Entity;
import domain.maestro.value.EspecialidadId;
import domain.maestro.value.NombreEspecialidad;


public class Especialidad extends Entity<EspecialidadId> {
    private NombreEspecialidad nombreEspecialidad;

    public Especialidad(EspecialidadId especialidadId, NombreEspecialidad nombreEspecialidad) {
        super(especialidadId);
        this.nombreEspecialidad = nombreEspecialidad;
    }



}
