package domain.generic;

import co.com.sofka.domain.generic.Identity;

public class SalonId extends Identity {

        private SalonId(String valor){
            super(valor);
        }
        public SalonId(){}

        public static SalonId of(String valor) {
            return new SalonId(valor);
        }
}
