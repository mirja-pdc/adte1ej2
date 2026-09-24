package ad1te1ej2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;


// Lee accesos.log línea a línea y genere errores.log con solo las líneas cuyo resultado es ERROR. 
// Al final del fichero se añade una línea con el total de errores encontrados.
// He tomado como modelo la solución al Ejercicio 2 de la Tarea de Aprendizaje 2
// (https://github.com/ad-birt/ud1-tareaAprendizaje2/blob/master/src/ejercicios/Ud1TareaAprendizaje2Ejercicio2.java)
public class BufferedReaderyBufferedWriter {

	  public static void main(String[] args) {
		    
		    // Se declara el String nomFich para usarlo en la gestión del error FileNotFoundException
		    // y para crear el fichero a leer sin hacer necesario usar ese nombre de fichero de entrada
		    String nomFich = "accesos.log";

		    try (BufferedReader fbr = new BufferedReader(new FileReader("." + File.separator + nomFich));
		    	 BufferedWriter fbw = new BufferedWriter(new FileWriter(new File("errores.log")))) {
		    	
		       // Contador de errores y variable String para guardar líneas leídas	
		       int errores = 0;
		       String linea = fbr.readLine();
		       
		       // Mientras haya líneas en el documento, se leen y procesan
		       while (linea != null) {
		    	 
		    	 // Si la línea termina con "ERROR", se genera un error y se suma 1 al contador de errores
		    	 if (linea.endsWith("ERROR")) {
		    		 
		    		 // Se escribe la línea con ERROR en errores.log
		    		 // Yo había intentado hacer fbw.writeLine(linea), usando un método que no existe,
		    		 // y Gemini me ha sugerido la forma correcta:
		    		 fbw.write(linea);   // Escribe el texto
		    		 fbw.newLine();     // Inserta el salto de línea
		    		 
		    		 // Se aumenta en uno el contador de errores
		    		 errores++;
		    	 } 
		    	 
		    	 // Se lee la línea termine o no con "ERROR", para avanzar a la siguiente línea con BufferedReader.
		    	 // Antes tenía "linea = fbr.readLine();" al principio del while (antes del if), 
		    	 // generando un NullPointerException al intentar ejecutar el programa. 
		    	 // La he movido aquí por sugerencia de Gemini, para no saltarse procesar la primera 
		    	 // línea en el if, y para que el programa no termine
		    	 // intentando ejecutar linea.endsWith("ERROR") cuando línea tiene el valor null
		    	 linea = fbr.readLine();
		         
		       }
		       
		       // Se añade al final de errores.log una línea con el total de errores encontrados en accesos.log
		       fbw.write("Se han encontrado " + errores + " errores en " + nomFich + ".");
		       
		    } catch (FileNotFoundException e) {
		    	
		       System.out.println("No existe fichero " + nomFich);
		      
		    } catch (IOException e) {
		    	
		       System.out.println("Error de E/S: " + e.getMessage());
		      
		    } catch (Exception e) {
		    	
		       e.printStackTrace();
		      
		    }

	  }
}
