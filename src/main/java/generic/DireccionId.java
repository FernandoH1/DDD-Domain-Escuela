package generic;

import co.com.sofka.domain.generic.Identity;

public class DireccionId extends Identity {

    private DireccionId(String valor){
        super(valor);
    }
    public DireccionId(){}

    public static DireccionId of(String valor) {
        return new DireccionId(valor);
    }
}
