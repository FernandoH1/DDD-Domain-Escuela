package generic;

import co.com.sofka.domain.generic.Identity;

public class MaestroId extends Identity {

    private MaestroId(String valor){
        super(valor);
    }
    public MaestroId(){}

    public static MaestroId of(String valor) {
        return new MaestroId(valor);
    }
}