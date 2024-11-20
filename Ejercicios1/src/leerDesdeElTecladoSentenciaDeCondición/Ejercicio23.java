
package leerDesdeElTecladoSentenciaDeCondición;

import java.util.Scanner;

public class Ejercicio23 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese el primer numero: ");
        int a = s.nextInt();
        
        System.out.print("Ingrese el segundo numero: ");
        int b = s.nextInt();

        int gcd = calcGCD(a, b);

        System.out.println("El gcd de " + a + " y " + b + " es: " + gcd);

    }

    public static int calcGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

