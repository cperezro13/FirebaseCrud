
package leerDesdeElTecladoSentenciaDeCondición;

import java.util.Scanner;

public class Ejercicio22 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Ingrese un numero entero: ");
        int numero = s.nextInt();

        for (int i = 1; i < numero; i += 2) {
            System.out.println(i);
        }
    }
}
