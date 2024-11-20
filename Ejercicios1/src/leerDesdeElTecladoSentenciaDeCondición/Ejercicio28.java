
package leerDesdeElTecladoSentenciaDeCondición;

public class Ejercicio28 {
    public static void main(String[] args) {
        System.out.println("Ejecutando con 'break' en el switch:\n");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Valor de i: " + i);
            
            switch (i) {
                case 1:
                    System.out.println("Caso 1: i es igual a 1");
                    break;
                case 2:
                    System.out.println("Caso 2: i es igual a 2");
                    break;
                case 3:
                    System.out.println("Caso 3: i es igual a 3");
                    break;
                case 4:
                    System.out.println("Caso 4: i es igual a 4");
                    break;
                case 5:
                    System.out.println("Caso 5: i es igual a 5");
                    break;
                default:
                    System.out.println("Caso por defecto");
            }
        }

        System.out.println("\n---------------------------------------------\n");

        System.out.println("Ejecutando sin 'break' en el switch:\n");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Valor de i: " + i);
            
            switch (i) {
                case 1:
                    System.out.println("Caso 1: i es igual a 1");
                case 2:
                    System.out.println("Caso 2: i es igual a 2");
                case 3:
                    System.out.println("Caso 3: i es igual a 3");
                case 4:
                    System.out.println("Caso 4: i es igual a 4");
                case 5:
                    System.out.println("Caso 5: i es igual a 5");
                default:
                    System.out.println("Caso por defecto");
            }
        }
    }
}
