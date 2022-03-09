package generic;

import co.com.sofka.domain.generic.Identity;

public class NombreId extends Identity {

    private NombreId(String valor){
        super(valor);
    }
    public NombreId(){}

    public static NombreId of(String valor) {
        return new NombreId(valor);
    }
}