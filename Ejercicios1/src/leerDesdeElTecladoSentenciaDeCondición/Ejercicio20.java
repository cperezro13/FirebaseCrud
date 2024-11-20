
package leerDesdeElTecladoSentenciaDeCondición;

import java.util.Scanner;

public class Ejercicio20 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese la altura del rectangulo: ");
        double alt = s.nextDouble();
        
        System.out.print("Ingrese la anchura del rectangulo: ");
        double anch = s.nextDouble();

        double area = alt * anch;

        System.out.println("El area del rectangulo es: " + area);

    }
}
