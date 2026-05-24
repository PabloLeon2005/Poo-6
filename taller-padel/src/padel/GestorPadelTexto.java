package padel;

import java.io.*;
import java.util.ArrayList;

public class GestorPadelTexto {

    private String archivo;

    public GestorPadelTexto(String archivo) {
        this.archivo = archivo;
    }

    public void escribir(ArrayList<PartidoPadel> lista) {
        try {
            FileWriter fw = new FileWriter(archivo);
            for (PartidoPadel p : lista) {
                fw.write(p.getPareja1() + ";" + p.getPareja2() + ";" + p.getSetsPareja1() + ";" + p.getSetsPareja2() + "\n");
            }
            fw.close();
            System.out.println("Partidos escritos en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }
    }

    public ArrayList<PartidoPadel> leer() {
        ArrayList<PartidoPadel> lista = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            while (linea != null) {
                String[] partes = linea.split(";");
                String pareja1 = partes[0];
                String pareja2 = partes[1];
                int sets1 = Integer.parseInt(partes[2]);
                int sets2 = Integer.parseInt(partes[3]);
                lista.add(new PartidoPadel(pareja1, pareja2, sets1, sets2));
                linea = br.readLine();
            }
            br.close();
            System.out.println("Partidos leidos desde " + archivo);
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
        return lista;
    }
}
