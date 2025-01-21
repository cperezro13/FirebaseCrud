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
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class FirebaseSaveObject {

    public static void main(String[] args) throws FileNotFoundException {
        FirebaseSaveObject firebaseSaveObject = new FirebaseSaveObject();
        // Crear un nuevo objeto y guardarlo
        Item item = new Item();
        item.setId(100L);
        item.setName("PruebaCrud");
        item.setPrice(100.0);

        // Guardar el objeto en Firebase
        System.out.println("Guardando el objeto en Firebase...");
        firebaseSaveObject.save(item);

        // Leer todos los datos del nodo "item" (verificar que se guardó)
        System.out.println("Leyendo los datos del nodo 'item'...");
        firebaseSaveObject.readAll("item");

        // Eliminar los datos del nodo "item"
        //System.out.println("Eliminando los datos del nodo 'item'...");
        //firebaseSaveObject.delete("item");

    }

    private FirebaseDatabase firebaseDatabase;

    /**
     * inicialización de firebase.
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
     * Save item object in Firebase.
     *
     * @param item
     */
    private void save(Item item) throws FileNotFoundException {
        if (item != null) {
            initFirebase();

            DatabaseReference databaseReference = firebaseDatabase.getReference("/");

            DatabaseReference childReference = databaseReference.child("item");

            CountDownLatch countDownLatch = new CountDownLatch(1);
            childReference.setValue(item, new DatabaseReference.CompletionListener() {

                @Override
                public void onComplete(DatabaseError de, DatabaseReference dr) {
                    System.out.println("Registro guardado!");
                    countDownLatch.countDown();
                }
            });
            try {

                countDownLatch.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void recover() {
        initFirebase();

        if (firebaseDatabase == null) {
            System.err.println("Error: firebaseDatabase sigue siendo null después de inicializar.");
            return;
        }

        DatabaseReference databaseReference = firebaseDatabase.getReference("item");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Item value = dataSnapshot.getValue(Item.class);
                if (value != null) {
                    System.out.println("Objeto recuperado:");
                    System.out.println("ID: " + value.getId());
                    System.out.println("Nombre: " + value.getName());
                    System.out.println("Precio: " + value.getPrice());
                } else {
                    System.out.println("No se encontro ningun objeto en la base de datos.");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.err.println("Error al recuperar datos: " + error.getMessage());
            }
        });
    }

    private void delete(String key) {
        initFirebase();

        if (firebaseDatabase == null) {
            System.err.println("Error: firebaseDatabase sigue siendo null después de inicializar.");
            return;
        }


        DatabaseReference databaseReference = firebaseDatabase.getReference(key);

        databaseReference.removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                if (error == null) {
                    System.out.println("Datos eliminados correctamente del nodo: " + key);
                } else {
                    System.err.println("Error al eliminar datos: " + error.getMessage());
                }
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
                        System.out.println(snapshot.getKey() + " = " + snapshot.getValue());
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
