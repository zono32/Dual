package RepasoExamen2Eva.Exceptions;

public class ExcepFecha {
    public class ExcepNum extends Exception{
        static final int PRODUCTO_CADUCADO = 1;

        private String fallo;

        public ExcepNum(){

        }
        public ExcepNum(String s){
            super(s);
        }

        public ExcepNum(int f){
            switch (f){
                case 1 :
                    fallo = "ERROR: el producto esta caducado";
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

}
