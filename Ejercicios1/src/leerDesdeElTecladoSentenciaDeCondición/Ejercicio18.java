
package leerDesdeElTecladoSentenciaDeCondición;

import java.util.Scanner;

public class Ejercicio18 {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese un numero entero: ");
        
        int n = s.nextInt();
        
        int sum = 0;
        
        for(int i = n+1; i <= n+100 ; i++){
            sum += i;
        }
        System.out.println(sum);
        
    }

}
