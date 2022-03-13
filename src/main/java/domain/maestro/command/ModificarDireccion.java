package domain.maestro.command;

import co.com.sofka.domain.generic.Command;
import domain.generic.Direccion;
import domain.generic.MaestroId;

public class ModificarDireccion extends Command {
    private final MaestroId maestroId;
    private final Direccion direccion;

    public ModificarDireccion(MaestroId maestroId, Direccion direccion) {
        this.maestroId = maestroId;
        this.direccion = direccion;
    }

    public MaestroId getMaestroId() {
        return maestroId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
