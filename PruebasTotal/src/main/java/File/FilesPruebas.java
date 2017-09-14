package File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.security.auth.login.Configuration;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import es.juntadeandalucia.csbs.PruebasTotal.App;

public class FilesPruebas {

	static final Logger log = Logger.getLogger(App.class);
	
	public void creamosFichero() {

		
		log.info("estamos en el metodo de fichero");
		File fichero = new File("c:\\bea", "fichero.txt");
		BufferedWriter bw;

		try {
			// A partir del objeto File creamos el fichero físicamente
			if (fichero.createNewFile()) {
				System.out.println("El fichero se ha creado correctamente");
				System.out.println("Nombre del archivo " + fichero.getName());
				System.out.println("Camino             " + fichero.getPath());
				System.out.println("Camino absoluto    " + fichero.getAbsolutePath());
				System.out.println("Se puede escribir  " + fichero.canRead());
				System.out.println("Se puede leer      " + fichero.canWrite());
				System.out.println("Tamaño             " + fichero.length());
				
//				aqui podemos escribir dentro de el
			
			        if(fichero.exists()) {
			            bw = new BufferedWriter(new FileWriter(fichero));
			            bw.write("El fichero de texto ya estaba creado.");
			        } else {
			            bw = new BufferedWriter(new FileWriter(fichero));
			            bw.write("Acabo de crear el fichero de texto.");
			        }
			        bw.close();
			    
				
				
			} else {
				System.out.println("No ha podido ser creado el fichero");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public void pruebasDeProyecto() throws IOException {
		
		BasicConfigurator.configure();
	
		log.info("Mediante el comando System.getProperty(\"user.home\") nos da el usuario del equipo: "+System.getProperty("user.home"));
		log.info("File directorioHome = new File(dir);");
		
		File configuracionDatosPersonales = new File(System.getProperty("user.home"), "datosPersonales.conf");
		FileWriter fichero = new FileWriter(configuracionDatosPersonales);
	
		fichero.write("Alfonso");
		fichero.write("\r\n");
		fichero.write("Terrones Moreno");
		fichero.write("\r\n");
		fichero.write("647749447");
		fichero.close();

	}
	
	//prueba1
	public void lecturaDeFicheros() throws IOException {
		
		BasicConfigurator.configure();
		
		File archivo = new File (System.getProperty("user.home")+"\\datosPersonales.conf");
		FileReader fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		log.info("Estamos leyendo el archivo de configuracion"+linea);
	    linea = br.readLine();
	    log.info("Estamos leyendo el archivo de configuracion"+linea);
	}
}
