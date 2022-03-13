package domain.estudiante.value;

import co.com.sofka.domain.generic.Identity;

public class FaltaId extends Identity {
    private FaltaId(String id){
        super(id);
    }

    public FaltaId(){ }

    public static FaltaId of(String id) {
        return new FaltaId(id);
    }
}
