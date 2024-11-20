
package leerDesdeElTecladoSentenciaDeCondición;

import java.util.Scanner;

public class Ejercicio21 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese el primer numero: ");
        double n1 = s.nextDouble();
        
        System.out.print("Ingrese el segundo numero: ");
        double n2 = s.nextDouble();

        if (n1 > n2) {
            System.out.println("El mayor es: " + n1);
            System.out.println("El menor es: " + n2);
        } else if (n1 < n2) {
            System.out.println("El mayor es: " + n2);
            System.out.println("El menor es: " + n1);
        } else {
            System.out.println("Ambos números son iguales.");
        }

    }
}

