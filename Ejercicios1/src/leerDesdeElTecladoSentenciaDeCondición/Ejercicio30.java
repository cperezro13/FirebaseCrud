
package leerDesdeElTecladoSentenciaDeCondición;

public class Ejercicio30 {
    public static void main(String[] args) {
        int limite = 100;  
        System.out.println("Los números primos entre 1 y " + limite + " son:");
       
        for (int num = 2; num <= limite; num++) {
            boolean Primo = true; 
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    Primo = false;  
                    break;  
                }
            }

            if (Primo) {
                System.out.println(num);
            }
        }
    }
}

