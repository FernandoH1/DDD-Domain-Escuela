package domain.clase.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.clase.Clase;
import domain.clase.command.CrearClase;

public class CrearClaseUseCase extends UseCase<RequestCommand<CrearClase>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearClase> input) {
        var command = input.getCommand();
        var clase = new Clase(command.getClaseId(),command.getMaestroId(),command.getEstudianteId(),command.getPuntaje(),command.getTurno());
        emit().onResponse(new ResponseEvents(clase.getUncommittedChanges()));
    }
}
