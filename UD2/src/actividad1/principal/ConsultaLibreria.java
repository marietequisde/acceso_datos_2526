package actividad1.principal;

import entrada.Teclado;

public class ConsultaLibreria {

    public static void main(String[] args) {
        int opcion;
        do {
            escribirMenuOpciones();
            opcion = Teclado.leerEntero("opcion: ");

            try {
                switch (opcion) {
                case 0:
                    
                    break;
                    
                case 1:
                    System.err.println("No implementado.");
                    break;
                default:
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (opcion != 0);

    }
    
    private static void escribirMenuOpciones() {
        System.out.println();
        System.out.println("(0) Salir.");
        System.out.println("(1) ");
        System.out.println();
    }

}
