package domain.estudiante.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.estudiante.Estudiante;
import domain.estudiante.command.CambiarNombre;


public class CambiarNombreUseCase extends UseCase<RequestCommand<CambiarNombre>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarNombre> input) {
        var command = input.getCommand();
        var estudiante = Estudiante.from(command.getEstudianteId(), retrieveEvents());
        try{
            estudiante.cambiarNombre(command.getNombre());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getEstudianteId().value(), e.getMessage());
        }
        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}