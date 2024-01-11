package ejerciciosPOO;

class Principal {

    public static void main(String[] args) {

        Cuenta c1 = new Cuenta("Maria", 0);
        Cuenta c2 = new Cuenta("Pepe", 500);
        Cuenta c3 = new Cuenta("Ana");

        c1.ingresar(300);
        c2.ingresar(200);
        c3.ingresar(50);

        System.out.println("ANTES DE RETIRADA:");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        c1.retirar(450);
        c2.retirar(100);
        c3.retirar(100);

        System.out.println("\nDESPUES DE RETIRADA:");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

    }
}