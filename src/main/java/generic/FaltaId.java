package generic;

import co.com.sofka.domain.generic.Identity;

public class FaltaId extends Identity {

    private FaltaId(String valor){
        super(valor);
    }
    public FaltaId(){}

    public static FaltaId of(String valor) {
        return new FaltaId(valor);
    }
}
