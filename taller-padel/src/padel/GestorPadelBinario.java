package padel;

import java.io.*;
import java.util.ArrayList;

public class GestorPadelBinario {

    private String archivo;

    public GestorPadelBinario(String archivo) {
        this.archivo = archivo;
    }

    public void guardar(ArrayList<PartidoPadel> lista) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(lista);
            oos.close();
            System.out.println("Partidos guardados en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public ArrayList<PartidoPadel> cargar() {
        ArrayList<PartidoPadel> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                for (Object item : (ArrayList<?>) obj) {
                    if (item instanceof PartidoPadel) {
                        lista.add((PartidoPadel) item);
                    }
                }
            }
            System.out.println("Partidos cargados desde " + archivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("No se reconocio la clase: " + e.getMessage());
        }
        return lista;
    }
}
