package domain.estudiante.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.estudiante.Estudiante;
import domain.estudiante.command.CrearEstudiante;
import domain.maestro.Maestro;
import domain.maestro.command.CrearMaestro;

public class CrearEstudianteUseCase extends UseCase<RequestCommand<CrearEstudiante>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearEstudiante> input) {
        var command = input.getCommand();
        var estudiante = new Estudiante(command.getEstudianteId(),command.getNombre(),command.getDireccion(),command.getUtiles(),command.getNota(),command.getFalta());
        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}
