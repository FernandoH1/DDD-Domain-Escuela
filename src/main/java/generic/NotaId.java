package generic;

import co.com.sofka.domain.generic.Identity;

public class NotaId extends Identity {

    private NotaId(String valor){
        super(valor);
    }
    public NotaId(){}

    public static NotaId of(String valor) {
        return new NotaId(valor);
    }
}
