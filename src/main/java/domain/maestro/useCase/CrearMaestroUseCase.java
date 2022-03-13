package domain.maestro.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.maestro.Maestro;
import domain.maestro.command.CrearMaestro;


public class CrearMaestroUseCase extends UseCase<RequestCommand<CrearMaestro>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearMaestro> input) {
        var command = input.getCommand();
        var maestro = new Maestro(command.getMaestroId(),command.getInformacionPersonal(),command.getDireccion(),command.getUtiles(),command.getEspecialidad());
        emit().onResponse(new ResponseEvents(maestro.getUncommittedChanges()));
    }
}
