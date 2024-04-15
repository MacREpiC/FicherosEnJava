package org.iesalandalus.programacion.actividades.ficherosxml;

import org.iesalandalus.programacion.UtilidadesXml;
import org.iesalandalus.programacion.actividades.serializacionObjetos.Persona;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConvertirFicheroObjetosAXmlConElementos {
    /*Escribir un programa en java que lea un fichero de objetos con datos sobre una
    persona y los escriba como un fichero XML, almacenando los valores en elementos.*/
    private static final String FICHERO_OBJETOS = String.format("%s%s%s","ficheros", File.separator, "personas.dat");
    private static final String FICHERO_XML = String.format("%s%s%s", "ficheros", File.separator, "salidaPersonasElementos.xml");

    public static void main(String[] args) {
        List<Persona> personas = leerFicheroObjetos();
        Document documentoXml = crearDocumentoXml(personas);
        UtilidadesXml.escribirDocumentoXml(documentoXml, FICHERO_XML);
    }

    private static List<Persona> leerFicheroObjetos() {
        List<Persona> personas = new ArrayList<>();
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO_OBJETOS))){
            Persona persona;
            while ((persona = (Persona)entrada.readObject()) != null) {
                personas.add(persona);
            }
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

    private static Document crearDocumentoXml(List<Persona> personas) {
        DocumentBuilder constructor = UtilidadesXml.crearConstructorDocumentoXml();
        Document documentoXml = null;
        if (constructor != null) {
            documentoXml = constructor.newDocument();
            documentoXml.appendChild(documentoXml.createElement("personas"));
            for (Persona persona : personas) {
                Element elementoPersona = crearElementoPersonaConElementos(documentoXml, persona);
                documentoXml.getDocumentElement().appendChild(elementoPersona);
            }
        }
        return documentoXml;
    }

    private static Element crearElementoPersonaConElementos(Document documentoXml, Persona persona) {
        Element elementoPersona = documentoXml.createElement("persona");
        Element elementoNombre = documentoXml.createElement("nombre");
        elementoNombre.setTextContent(persona.getNombre());
        Element elementoEdad = documentoXml.createElement("edad");
        elementoEdad.setTextContent(String.format("%d", persona.getEdad()));
        elementoPersona.appendChild(elementoNombre);
        elementoPersona.appendChild(elementoEdad);
        return elementoPersona;
    }
}
