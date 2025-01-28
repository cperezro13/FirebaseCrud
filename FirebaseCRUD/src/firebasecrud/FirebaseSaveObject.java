package firebasecrud;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class FirebaseSaveObject {

    public static void main(String[] args) throws FileNotFoundException {
        FirebaseSaveObject firebaseSaveObject = new FirebaseSaveObject();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nSelecciona una operacion:");
            System.out.println("1. Guardar un objeto");
            System.out.println("2. Leer todos los datos");
            System.out.println("3. Eliminar datos");
            System.out.println("4. Salir");
            System.out.print("Tu eleccion: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    Item newItem = new Item();
                    System.out.print("Ingresa el ID del item: ");
                    newItem.setId(scanner.nextLong());
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Ingresa el nombre del item: ");
                    newItem.setName(scanner.nextLine());
                    System.out.print("Ingresa el precio del item: ");
                    newItem.setPrice(scanner.nextDouble());
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.println("Guardando el objeto en Firebase...");
                    firebaseSaveObject.save(newItem);
                    break;
                case 2:
                    System.out.print("Ingresa el nodo que deseas leer: ");
                    String readKey = scanner.nextLine();
                    firebaseSaveObject.readAll(readKey);
                    break;
                case 3:
                    System.out.print("Ingresa el nodo que deseas eliminar: ");
                    String deleteKey = scanner.nextLine();
                    firebaseSaveObject.delete(deleteKey);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta de nuevo.");
            }
        }
        scanner.close();
    }

    private FirebaseDatabase firebaseDatabase;

    /**
     * Inicialización de Firebase.
     */
    private void initFirebase() {
        try {
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
                        .setDatabaseUrl("https://fir-crud-6a0bf-default-rtdb.firebaseio.com")
                        .setServiceAccount(new FileInputStream(
                                new File("C:\\Users\\crist\\Documents\\Unal\\POO\\ServiceAccounts\\fir-crud-6a0bf-firebase-adminsdk-fbsvc-61e91ef04a.json")))
                        .build();

                FirebaseApp.initializeApp(firebaseOptions);
                System.out.println("Firebase inicializado correctamente.");
            }
            firebaseDatabase = FirebaseDatabase.getInstance();
        } catch (FileNotFoundException ex) {
            System.err.println("Error: Archivo de configuración no encontrado.");
        } catch (RuntimeException ex) {
            System.err.println("Error al inicializar Firebase: " + ex.getMessage());
        }
    }

    /**
     * Guarda un objeto Item en Firebase.
     *
     * @param item El objeto a guardar.
     */
    private void save(Item item) throws FileNotFoundException {
        if (item != null) {
            initFirebase();

            DatabaseReference databaseReference = firebaseDatabase.getReference("/");

            DatabaseReference childReference = databaseReference.child("item");

            CountDownLatch countDownLatch = new CountDownLatch(1);
            childReference.setValue(item, (de, dr) -> {
                if (de == null) {
                    System.out.println("Registro guardado correctamente!");
                } else {
                    System.err.println("Error al guardar el registro: " + de.getMessage());
                }
                countDownLatch.countDown();
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void delete(String key) {
        initFirebase();

        if (firebaseDatabase == null) {
            System.err.println("Error: firebaseDatabase sigue siendo null después de inicializar.");
            return;
        }

        DatabaseReference databaseReference = firebaseDatabase.getReference(key);

        databaseReference.removeValue((error, ref) -> {
            if (error == null) {
                System.out.println("Datos eliminados correctamente del nodo: " + key);
            } else {
                System.err.println("Error al eliminar datos: " + error.getMessage());
            }
        });
    }

    private void readAll(String key) {
        initFirebase();

        if (firebaseDatabase == null) {
            System.err.println("Error: firebaseDatabase sigue siendo null después de inicializar.");
            return;
        }

        DatabaseReference databaseReference = firebaseDatabase.getReference(key);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    System.out.println("Datos encontrados en el nodo: " + key);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        System.out.println(snapshot.getKey() + " : " + snapshot.getValue());
                    }
                } else {
                    System.out.println("No hay datos en el nodo: " + key);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.err.println("Error al leer datos: " + error.getMessage());
            }
        });
    }
}
