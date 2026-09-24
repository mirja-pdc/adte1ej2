package ad1te1ej2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


// Lee accesos.log línea a línea y genere errores.log con solo las líneas cuyo resultado es ERROR. 
// Al final del fichero se añade una línea con el total de errores encontrados.
// He tomado como modelo la solución al Ejercicio 2 de la Tarea de Aprendizaje 2
// (https://github.com/ad-birt/ud1-tareaAprendizaje2/blob/master/src/ejercicios/Ud1TareaAprendizaje2Ejercicio2.java)
public class BufferedReaderyBufferedWriter {

	  public static void main(String[] args) {

		    try (BufferedReader fbr = new BufferedReader(new FileReader("." + File.separator + "accesos.log"));
		    	 BufferedWriter fbw = new BufferedWriter(new FileWriter(new File("errores.log")))) {
		    	
		       // Contador de errores y variable String para guardar líneas leídas	
		       int errores = 0;
		       String linea;
		       
		       // Mientras haya líneas en el documento
		       while (linea != null) {
		    	   
		    	 // Se lee la línea
		    	 linea = fbr.readLine();
		    	 
		    	 // Si la línea termina con "ERROR", se genera un error y se suma 1 al contador de errores
		    	 if (linea.endsWith("ERROR")) {
		    		 
		    		 // Se escribe la línea con ERROR en errores.log
		    		 fbw.writeLine(linea);
		    		 
		    		 // Se aumenta en uno el contador de errores
		    		 errores++;
		    	 }  
		    	 
		    	// Se añade al final de errores.log una línea con el total de errores encontrados en accesos.log
		    	fbw.writeLine("Se han encontrado " + errores + " errores en accesos.log.");
		         
		       }
		       
		    } catch (FileNotFoundException e) {
		    	
		       System.out.println("No existe fichero " + nomFich);
		      
		    } catch (IOException e) {
		    	
		       System.out.println("Error de E/S: " + e.getMessage());
		      
		    } catch (Exception e) {
		    	
		       e.printStackTrace();
		      
		    }

	  }
}
