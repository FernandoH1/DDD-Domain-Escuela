package domain.maestro.command;

import co.com.sofka.domain.generic.Command;
import domain.generic.Direccion;
import domain.generic.MaestroId;
import domain.maestro.entity.Especialidad;
import domain.maestro.entity.UtilesMaestro;
import domain.maestro.value.InformacionPersonal;

import java.util.Set;

public class CrearMaestro extends Command {
    private final MaestroId maestroId;
    private final InformacionPersonal informacionPersonal;
    private final Direccion direccion;
    private final Set<UtilesMaestro> utiles;
    private final Especialidad especialidad;

    public CrearMaestro(MaestroId maestroId, InformacionPersonal informacionPersonal, Direccion direccion, Set<UtilesMaestro> utiles, Especialidad especialidad) {
        this.maestroId = maestroId;
        this.informacionPersonal = informacionPersonal;
        this.direccion = direccion;
        this.utiles = utiles;
        this.especialidad = especialidad;
    }

    public MaestroId getMaestroId() {
        return maestroId;
    }

    public InformacionPersonal getInformacionPersonal() {
        return informacionPersonal;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Set<UtilesMaestro> getUtiles() {
        return utiles;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
