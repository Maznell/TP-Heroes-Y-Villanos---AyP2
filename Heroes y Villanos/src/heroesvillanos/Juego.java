package heroesvillanos;

import java.io.*;
import java.util.*;

public class Juego {

	public static void main(String[] args) throws IOException {

		Juego juego = new Juego();

		juego.menuPrincipal();
	}

	// Carga el menú del juego
	public void menuPrincipal() throws IOException {

		Scanner entrada = new Scanner(System.in);
		int opcion;

		System.out.println("---MENÚ PRINCIPAL---");
		System.out.println("1) Admin. Personajes");
		System.out.println("2) Admin. Ligas");
		System.out.println("3) Arena");
		System.out.println("4) Salir");

		opcion = entrada.nextInt();

		switch (opcion) {

		case 1:
			menuAdminPersonajes();
			break;
		case 2:
			// Agregar Administración de Ligas (parecido al administrar Personajes)
			break;
		case 3:
			// Agregar Menú de Combate (1- Personaje vs Personaje para empezar)
			break;
		case 4:
			System.exit(0); // Salir del sistema.
		default:
			// Agregar excepción por entrada no válida (cuando no se selecciona 1, 2 ,3 o 4)
			break;
		}

	}

	private void menuAdminPersonajes() throws IOException {

		Scanner entrada = new Scanner(System.in);
		int opcion;

		System.out.println("---MENÚ PERSONAJES---");
		System.out.println("1) Cargar desde Archivo");
		System.out.println("2) Agregar Personaje (manual)");

		opcion = entrada.nextInt();

		switch (opcion) {

		case 1:
			menuCargaDeArchivo();
			break;
		case 2:
			menuAgregarPersonaje();
		}
	}

	private void menuAgregarPersonaje() {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("---AGREGAR PERSONAJE NUEVO---");
		System.out.println("Escriba los datos del personaje siguiendo el siguiente formato:");
		System.out.println("Bando,Nombre,Alias,Velocidad,Fuerza,Resistencia,Destreza");
		
		String personaje = entrada.nextLine().trim();
		
		Personaje personajeCreado = crearPersonaje(personaje);
		
		System.out.println("El personaje se creó. Se ha grabado de la siguiente manera:");
		System.out.println(personajeCreado);
	}

	private void menuCargaDeArchivo() throws IOException {

		Scanner entrada = new Scanner(System.in);

		System.out.println("---CARGA DE ARCHIVO---");
		System.out.println("Indique la ruta del archivo");

		String ruta = entrada.nextLine();

		cargarArchivo(ruta);
	}

	private void cargarArchivo(String ruta) throws IOException {

		BufferedReader lector = new BufferedReader(new FileReader(ruta));

		String linea = lector.readLine();

		while (linea != null) {

			linea = linea.trim();
			crearPersonaje(linea);
			System.out.println(linea);
			linea = lector.readLine();
		}
	}

	private Personaje crearPersonaje(String linea) {

		Personaje personaje;
		String[] parametrosPersonaje = linea.split(",");

		String nombreReal = parametrosPersonaje[1].trim();
		String nombrePersonaje = parametrosPersonaje[2].trim();
		int velocidad = Integer.parseInt(parametrosPersonaje[3].trim());
		int fuerza = Integer.parseInt(parametrosPersonaje[4].trim());
		int resistencia = Integer.parseInt(parametrosPersonaje[5].trim());
		int destreza = Integer.parseInt(parametrosPersonaje[6].trim());

		if (parametrosPersonaje[0].toLowerCase().equals("héroe")
				|| parametrosPersonaje[0].toLowerCase().equals("heroe")) {

			personaje = new Heroe(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
		} else {

			personaje = new Villano(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
		}

		return personaje;
	}
}
