package generic;

import co.com.sofka.domain.generic.Identity;

public class EstudianteId extends Identity {

    private EstudianteId(String valor){
        super(valor);
    }
    public EstudianteId(){}

    public static EstudianteId of(String valor) {
        return new EstudianteId(valor);
    }
}