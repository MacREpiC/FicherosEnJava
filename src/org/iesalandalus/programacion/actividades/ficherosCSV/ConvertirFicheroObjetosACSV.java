package org.iesalandalus.programacion.actividades.ficherosCSV;

import org.iesalandalus.programacion.actividades.serializacionObjetos.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConvertirFicheroObjetosACSV {
    /*Escribir un programa en java que lea un fichero de objetos con datos sobre una persona y
    los escriba como un fichero CSV.*/
    private static final String FICHERO_OBJETOS = String.format("%s%s%s", "ficheros", File.separator, "personas.dat");
    private static final String FICHERO_CSV = String.format("%s%s%s", "ficheros", File.separator, "personas.csv");

    private static final String SEPARADOR = ",";

    public static void main(String[] args) {
        List<Persona> personas = leerFicheroObjectos();
        escribeFicheroCSV(personas);
    }

    private static List<Persona> leerFicheroObjectos() {
        List<Persona> personas = new ArrayList<>();
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO_OBJETOS))) {
            Persona persona;
            while ((persona = (Persona) entrada.readObject()) != null) {
                personas.add(persona);
            }
            System.out.println("Fichero CSV leído correctamente.");
        } catch (FileNotFoundException fnfe) {
            System.out.printf("No se puede leer el fichero de entrada: %s.%n", FICHERO_OBJETOS);
        } catch (ClassNotFoundException cnfee) {
            System.out.println("No puedo encontrar la clase que tengo que leer.");
        } catch (EOFException eo) {
            System.out.println("Fichero de objetos leído satisfactoriamente.");
        } catch (IOException e) {
            System.out.println("Error inesperado de Entrada/Salida.");
        }
        return personas;
    }

    private static void escribeFicheroCSV(List<Persona> personas) {
        try (BufferedWriter salida = new BufferedWriter(new FileWriter(FICHERO_CSV))){
            for (Persona persona : personas) {
                salida.write(String.format("%s%s%d%n", persona.getNombre(), SEPARADOR, persona.getEdad()));
            }
            System.out.println("Fichero CSV escrito satisfactoriamente.");
        } catch (FileNotFoundException fnfe) {
            System.out.printf("No se puede leer el fichero de salida: %s.%n", FICHERO_CSV);
        } catch (IOException e) {
            System.out.printf("No se ha podido escribir el fichero %s.%n", FICHERO_CSV);
        }
    }
}
