package domain.maestro.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.maestro.Maestro;
import domain.maestro.command.ModificarDireccion;


public class CambiarDireccionUseCase extends UseCase<RequestCommand<ModificarDireccion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarDireccion> input) {
        var command = input.getCommand();
        var maestro = Maestro.from(command.getMaestroId(), retrieveEvents());
        try{
            maestro.cambiarDireccion(command.getDireccion());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getMaestroId().value(), e.getMessage());
        }
        emit().onResponse(new ResponseEvents(maestro.getUncommittedChanges()));
    }
}