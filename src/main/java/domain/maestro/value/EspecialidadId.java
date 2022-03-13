package domain.maestro.value;

import co.com.sofka.domain.generic.Identity;

public class EspecialidadId extends Identity {
    private EspecialidadId(String id){
        super(id);
    }

    public EspecialidadId(){ }

    public static EspecialidadId of(String id) {
        return new EspecialidadId(id);
    }
}