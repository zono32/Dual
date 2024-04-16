package Instituto;

import java.util.Scanner;

public class Principal {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            menu();
            option = sc.nextInt();
            switch (option){
                case 1:{

                }break;

                case 2:{

                }break;

                case 3:{

                }break;

                case 4:{

                }break;

                case 5:{

                }break;

                case 6:{

                }break;

                case 7:{
                    System.out.println("Hasta pronto");
                }break;

                default: {
                    System.out.println("Por favor elija una opción correcta del menú");
                }break;
            }

        }while (option !=7);
    }


    private static void menu() {
        System.out.println("--------------------");
        System.out.println("Menú de Instituto");
        System.out.println("--------------------");

        System.out.println("Escoja la opción que desea realizar");
        System.out.println(" 1. altas");
        System.out.println(" 2. bajas");
        System.out.println("3: Listados de alumnos y profesores");
        System.out.println("4: Consulta 1: Edad media del profesorado");
        System.out.println("5: Consulta 2: Nota media del ciclo DAM");
        System.out.println("6: Consulta 3: Salario medio del profesorado");
        System.out.println("7: Salir");
    }
}
