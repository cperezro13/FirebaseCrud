
package leerDesdeElTecladoSentenciaDeCondición;

import java.util.Scanner;

public class Ejercicio24 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese el coeficiente a: ");
        double a = s.nextDouble();
        
        System.out.print("Ingrese el coeficiente b: ");
        double b = s.nextDouble();
        
        System.out.print("Ingrese el coeficiente c: ");
        double c = s.nextDouble();

        if (a == 0) {
            System.out.println("No es una ecuacion cuadratica (a no puede ser 0).");
        } else {
            double discriminante = b * b - 4 * a * c;

            if (discriminante > 0) {
                double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                System.out.println("Las soluciones son: x1 = " + x1 + " y x2 = " + x2);
            } else if (discriminante == 0) {
                double x = -b / (2 * a);
                System.out.println("La solucion es: x = " + x);
            } else {
                System.out.println("La ecuacion no tiene soluciones reales.");
            }
        }

    }
}
