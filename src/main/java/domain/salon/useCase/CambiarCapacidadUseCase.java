package domain.salon.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import domain.salon.Salon;
import domain.salon.command.ModificarCapacidad;

public class CambiarCapacidadUseCase extends UseCase<RequestCommand<ModificarCapacidad>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarCapacidad> input) {
        var command = input.getCommand();
        var salon = Salon.from(command.getSalonId(), retrieveEvents());
        try{
            salon.cambiarCapacidad(command.getCapacidad());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getSalonId().value(), e.getMessage());
        }
        emit().onResponse(new ResponseEvents(salon.getUncommittedChanges()));
    }
}
