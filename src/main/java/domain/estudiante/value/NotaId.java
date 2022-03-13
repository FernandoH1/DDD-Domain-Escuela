package domain.estudiante.value;

import co.com.sofka.domain.generic.Identity;

public class NotaId extends Identity {
    private NotaId(String id){
        super(id);
    }

    public NotaId(){ }

    public static NotaId of(String id) {
        return new NotaId(id);
    }
}
