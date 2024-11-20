
package leerDesdeElTecladoSentenciaDeCondición;

import java.util.Scanner;

public class Ejercicio19 {
    public static void main(String[] args) {

        double tipoDeCambio = 1.07;
        
        Scanner s = new Scanner(System.in);
   
        System.out.print("Ingrese la cantidad en euros: ");
        double e = s.nextDouble();
        
        double d = e * tipoDeCambio;

        System.out.println(e + " euros equivalen a " + d + " dolares.");

        
    }
}
