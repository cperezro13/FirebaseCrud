
package leerDesdeElTecladoSentenciaDeCondición;

import java.util.Scanner;

public class Ejercicio25 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese un numero entero para calcular su factorial: ");
        int n = s.nextInt();
        int resultadoFactorial = calcularFactorial(n);
        System.out.println("El factorial de " + n + " es: " + resultadoFactorial);

        System.out.print("Ingrese el valor de m para la funcion de Ackermann: ");
        int m = s.nextInt();
        System.out.print("Ingrese el valor de n para la funcion de Ackermann: ");
        int nAckermann = s.nextInt();
        int resultadoAckermann = calcularAckermann(m, nAckermann);
        System.out.println("El resultado de A(" + m + ", " + nAckermann + ") es: " + resultadoAckermann);

    }

    public static int calcularFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * calcularFactorial(n - 1);
        }
    }

    public static int calcularAckermann(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (m > 0 && n == 0) {
            return calcularAckermann(m - 1, 1);
        } else {
            return calcularAckermann(m - 1, calcularAckermann(m, n - 1));
        }
    }
}
