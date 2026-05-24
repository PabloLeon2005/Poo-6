# Taller Pádel - Sistema de Persistencia en Java

Proyecto de laboratorio para comparar mecanismos de persistencia en Java:
**Serialización Binaria (.dat)** vs **Texto Plano (.txt)**.

## Estructura del Proyecto

```
taller-padel/
├── src/
│   └── padel/
│       ├── PartidoPadel.java       # Clase modelo (Serializable)
│       ├── GestorPadelBinario.java # Persistencia binaria (.dat)
│       ├── GestorPadelTexto.java   # Persistencia texto plano (.txt)
│       └── Main.java               # Clase principal + Informe de resultados
├── .gitignore
└── README.md
```

## Cómo compilar y ejecutar

### Desde la línea de comandos

```bash
# Entrar al directorio src
cd src

# Compilar todas las clases
javac padel/*.java

# Ejecutar
java padel.Main
```

### Con IntelliJ IDEA o Eclipse
1. Abrir el proyecto apuntando a la carpeta `taller-padel/`
2. Marcar `src/` como Sources Root
3. Ejecutar `padel.Main`

## Salida esperada

```
=== TALLER PÁDEL - Sistema de Persistencia ===

--- 1. Creando partidos ---
  Partido: García / López vs Martínez / Sánchez | Marcador: 6 - 3
  ...
--- 2. Guardando en formato binario (.dat) ---
[Binario] Partidos guardados exitosamente en: partidos.dat
...
--- 6. Verificación de integridad ---
  Binario (.dat) - registros OK: true (3/3)
  Texto   (.txt) - registros OK: true (3/3)
```

## Informe de Resultados

Ver los comentarios en `Main.java` (bloque de documentación al inicio de la clase).

### Pregunta 1 — ¿Qué sucede al abrir el `.dat` con un editor de texto?
El archivo muestra caracteres ilegibles (bytes binarios). Contiene la cabecera mágica de serialización Java, metadatos de clase y valores de atributos en binario. No es legible ni procesable por herramientas externas.

### Pregunta 2 — Principal inconveniente del `.txt` frente al `.dat` cuando el sistema crece
La fragilidad del parseo manual: relaciones entre objetos, tipos complejos (fechas, enums, listas anidadas) deben convertirse a String y parsearse manualmente. Cada nuevo atributo exige actualizar tanto escritura como lectura. La serialización binaria gestiona todo esto automáticamente.
