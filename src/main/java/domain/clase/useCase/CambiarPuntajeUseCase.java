package domain.clase.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.clase.Clase;
import domain.clase.command.ModificarPuntaje;

public class CambiarPuntajeUseCase extends UseCase<RequestCommand<ModificarPuntaje>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarPuntaje> input) {
        var command = input.getCommand();
        var clase = Clase.form(command.getClaseId(), retrieveEvents());
        try{
            clase.cambiarPuntaje(command.getPuntaje());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getClaseId().value(), e.getMessage());
        }
        emit().onResponse(new ResponseEvents(clase.getUncommittedChanges()));
    }
}
