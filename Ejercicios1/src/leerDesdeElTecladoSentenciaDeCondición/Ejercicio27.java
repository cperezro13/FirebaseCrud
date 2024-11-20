
package leerDesdeElTecladoSentenciaDeCondición;

import java.util.Scanner;

public class Ejercicio27 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("Ingrese la temperatura en grados Fahrenheit : ");
            double f = s.nextDouble();

            if (f == 999) {
                break;
            }

            double c = 5.0 / 9.0 * (f - 32);

            System.out.println("La temperatura en grados Celsius es: " + c);
        }
    }
}

