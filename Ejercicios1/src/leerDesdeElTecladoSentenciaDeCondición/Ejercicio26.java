
package leerDesdeElTecladoSentenciaDeCondición;

import java.util.Scanner;

public class Ejercicio26 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese el primer numero entero positivo: ");
        int num1 = s.nextInt();
        
        System.out.print("Ingrese el segundo numero entero positivo: ");
        int num2 = s.nextInt();
        
        System.out.print("Ingrese el tercer numero entero positivo: ");
        int num3 = s.nextInt();

        if (num1 <= 0 || num2 <= 0 || num3 <= 0) {
            System.out.println("Todos los numeros deben ser enteros positivos.");
        } else {
            int mayor = Math.max(num1, Math.max(num2, num3));
            int menor = Math.min(num1, Math.min(num2, num3));

            System.out.println("El mayor numero es: " + mayor);
            System.out.println("El menor numero es: " + menor);
        }
    }
}
