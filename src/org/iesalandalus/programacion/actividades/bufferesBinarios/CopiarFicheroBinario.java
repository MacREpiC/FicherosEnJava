package org.iesalandalus.programacion.actividades.bufferesBinarios;

import java.io.*;

public class CopiarFicheroBinario {
    /*Escribir un programa en java que copie un fichero binario en otro, utilizando buferes.*/

    public static final String FICHERO_ENTRADA = String.format("%s%s%s", "ficheros", File.separator, "ficheroBinarioEntrada.bin");
    public static final String FICHERO_SALIDA = String.format("%s%s%s", "ficheros", File.separator, "ficheroBinarioSalida.bin");
    public static void main(String[] args) {
        try (BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(FICHERO_ENTRADA)); BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream(FICHERO_SALIDA))){
            int dato;
            while ((dato = entrada.read()) != -1) {
                salida.write(dato);
            }
            System.out.println("Se ha copiado exitosamente el archivo binario.");
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero de entrada");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida");
        }
    }
}