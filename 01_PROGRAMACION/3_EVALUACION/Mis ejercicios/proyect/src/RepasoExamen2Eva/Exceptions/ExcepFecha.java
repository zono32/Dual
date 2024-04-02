package RepasoExamen2Eva.Exceptions;

public class ExcepFecha extends Exception {

        public static final int PRODUCTO_CADUCADO = 1;
        public static final int FECHA_FORMATO_INCORRECTO = 2;

        private String fallo;

        public ExcepFecha(){

        }
        public ExcepFecha(String s){
            super(s);
        }

        public ExcepFecha(int f){
            switch (f){
                case 1 :
                    fallo = "ERROR: el producto esta caducado";
                    break;
                case 2 :
                    fallo = "ERROR: el formato de la fecha es incorrecto";
                    break;
                default:
                    fallo= "ERROR DESCONOCIDO";
                    break;
            }
        }
        public String getMessage(){
            return fallo;
        }


}
