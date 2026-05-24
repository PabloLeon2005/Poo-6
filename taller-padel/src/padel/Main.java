package padel;

import java.util.ArrayList;

/*
 * INFORME DE RESULTADOS
 *
 * Pregunta 1: ¿Qué sucede si intentas abrir el archivo .dat con un editor de texto?
 *
 * Al abrirlo con un editor de texto (Notepad, VS Code, etc.) se ven caracteres
 * extraños e ilegibles, símbolos sin sentido y secuencias de bytes. Esto ocurre
 * porque el archivo no guarda texto sino bytes que representan el objeto Java
 * directamente en memoria. No es posible leerlo ni editarlo de forma manual.
 *
 * Pregunta 2: ¿Cuál es el principal inconveniente de usar .txt frente a .dat
 * cuando el sistema crece en complejidad?
 *
 * El principal inconveniente es que hay que escribir y mantener manualmente el
 * código de lectura y escritura. Si la clase PartidoPadel crece (más atributos,
 * o atributos que son otros objetos), hay que actualizar tanto el método escribir()
 * como el leer(), y además asegurarse de que el formato del archivo no rompa
 * con datos anteriores. Con .dat la serialización de Java maneja todo eso
 * de forma automática.
 */

public class Main {

    public static void main(String[] args) {

        // 1. Crear partidos
        ArrayList<PartidoPadel> partidos = new ArrayList<>();
        partidos.add(new PartidoPadel("Garcia / Lopez", "Martinez / Sanchez", 6, 3));
        partidos.add(new PartidoPadel("Rodriguez / Perez", "Fernandez / Gomez", 4, 6));
        partidos.add(new PartidoPadel("Torres / Ruiz", "Moreno / Jimenez", 6, 1));

        System.out.println("=== Partidos creados ===");
        for (PartidoPadel p : partidos) {
            System.out.println(p);
        }

        // 2. Guardar en binario
        System.out.println("\n=== Guardando en binario (.dat) ===");
        GestorPadelBinario gestorBinario = new GestorPadelBinario("partidos.dat");
        gestorBinario.guardar(partidos);

        // 3. Guardar en texto
        System.out.println("\n=== Guardando en texto (.txt) ===");
        GestorPadelTexto gestorTexto = new GestorPadelTexto("partidos.txt");
        gestorTexto.escribir(partidos);

        // 4. Cargar desde binario y mostrar
        System.out.println("\n=== Cargando desde binario (.dat) ===");
        ArrayList<PartidoPadel> cargadosBinario = gestorBinario.cargar();
        for (PartidoPadel p : cargadosBinario) {
            System.out.println(p);
        }

        // 5. Cargar desde texto y mostrar
        System.out.println("\n=== Cargando desde texto (.txt) ===");
        ArrayList<PartidoPadel> cargadosTexto = gestorTexto.leer();
        for (PartidoPadel p : cargadosTexto) {
            System.out.println(p);
        }
    }
}
