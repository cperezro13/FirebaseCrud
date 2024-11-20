
package leerDesdeElTecladoSentenciaDeCondición;

import java.util.Scanner;

public class Ejercicio29 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Ingrese texto. Para finalizar, presione Ctrl+D (Linux/macOS) o Ctrl+Z (Windows).");

        while (s.hasNext()) {
            String input = s.nextLine();
            System.out.println("Usted ingreso: " + input);
        }

        System.out.println("Fin de archivo alcanzado. El programa se ha detenido.");
        
        s.close();
    }
}

