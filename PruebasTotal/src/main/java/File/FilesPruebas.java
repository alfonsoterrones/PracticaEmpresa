package File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.security.auth.login.Configuration;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import es.juntadeandalucia.csbs.PruebasTotal.App;

public class FilesPruebas {

	static final Logger log = Logger.getLogger(App.class);

	
	public void pruebasDeProyecto() throws IOException {

		BasicConfigurator.configure();

		log.info("Mediante el comando System.getProperty(\"user.home\") nos da el usuario del equipo: "
				+ System.getProperty("user.home"));
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

	public void lecturaDeFicheros() throws IOException {

		BasicConfigurator.configure();

		File archivo = new File(System.getProperty("user.home") + "\\datosPersonales.conf");
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		log.info("Estamos leyendo el archivo de configuracion" + linea);
		linea = br.readLine();
		log.info("Estamos leyendo el archivo de configuracion" + linea);
	}

	public void calculaDeEdad() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse("22/08/1985", fmt);
		LocalDate mas = LocalDate.parse("24/01/1991", fmt);
		LocalDate ahora = LocalDate.now();

		BasicConfigurator.configure();
		log.info("fecha actual " + ahora);
		log.info("fecha de nac " + fechaNac);
		Period diferencia = Period.between(fechaNac, mas);
		Period periodo = Period.between(fechaNac, ahora);
		System.out.printf("Tu edad es: %s años, %s meses y %s días", diferencia.getYears(), diferencia.getMonths(),
				diferencia.getDays());
	}

	private static Thread hilo;

	@SuppressWarnings("all")
	public void metodoPrueba() throws Exception {
		Exception exception = new Exception();
		int a = 98;
		int b = 101;

		if (a > 100 || b > 100) {
			log.info("Estamos dentro del if");

			if (hilo == null) {
				log.info("estamos dentro del if y dentro de los hilos");
				log.info(hilo);
				hilo = new Thread();
				log.info(hilo);
				hilo.start();
				log.info(hilo);
			}

			log.fatal(getClass());
			// log.fatal("Es posible que el objeto a no valga 100",exception);
			log.fatal("Es posible que el objeto a no valga 100");
			log.warn(log.getAdditivity());
			log.warn(log.getAllAppenders());

		} else {
			throw new Exception("El usuario es erroneoooo!!!!!");
		}
	}
	
	public void inetAddresPruebas() {
		 try {
		      System.out.println( "-> Direccion IP de una URL, por nombre" );  
		      InetAddress address = InetAddress.getByName( "nereida.deioc.ull.es" );
		      System.out.println( address );

		      // Extrae la dirección IP a partir de la cadena que se
		      // encuentra a la derecha de la barra /, luego proporciona
		      // esta dirección IP como argumento de llamada al método getByName()

		      System.out.println( "-> Nombre a partir de la direccion" );
		      int temp = address.toString().indexOf( '/' );
		      address = InetAddress.getByName( address.toString().substring(temp+1) );
		      System.out.println( address );
		       
		      System.out.println( "-> Direccion IP actual de LocalHost" );
		      address = InetAddress.getLocalHost();
		      System.out.println( address );

		      System.out.println( "-> Nombre de LocalHost a partir de la direccion" );
		      temp = address.toString().indexOf( '/' );
		      address = InetAddress.getByName( address.toString().substring(temp+1) );
		      System.out.println( address );

		      System.out.println( "-> Nombre actual de LocalHost" );
		      System.out.println( address.getHostName() );
		      //mas
		       
		      System.out.println( "-> Direccion IP actual de LocalHost" );
		      // Coge la dirección IP como un array de bytes
		      byte[] bytes = address.getAddress();
		      // Convierte los bytes de la dirección IP a valores sin
		      // signo y los presenta separados por espacios
		      for( int cnt=0; cnt < bytes.length; cnt++ ) {
		        int uByte = bytes[cnt] < 0 ? bytes[cnt]+256 : bytes[cnt];
		        System.out.print( uByte+" " );
		      }
		      System.out.println();
		      
		    
		     
		    } 
		    catch( UnknownHostException e ) {
		      System.out.println( e );
		      System.out.println( "Debes estar conectado para que esto funcione bien." );
		    }
	}
}
