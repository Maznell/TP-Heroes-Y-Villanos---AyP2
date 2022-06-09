package heroesvillanos;

import java.util.*;

public abstract class Personaje {

	private String nombreReal;
	private String nombrePersonaje;
	private List<Atributo> atributos = new ArrayList<Atributo>();

	public Personaje(String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia,
			int destreza) {

		setNombreReal(nombreReal);
		setNombrePersonaje(nombrePersonaje);
		setAtributos(velocidad, fuerza, resistencia, destreza);
	}
	
	
	//Para validación posterior. Este método verifica si un personaje es Héroe o no.
	public boolean esHeroe() {
		
		return this.getClass().equals(Heroe.class);
	}

	public String getNombreReal() {
		return nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public String getNombrePersonaje() {
		return nombrePersonaje;
	}

	public void setNombrePersonaje(String nombrePersonaje) {
		this.nombrePersonaje = nombrePersonaje;
	}

	public List<Atributo> getAtributos() {
		return atributos;
	}
	
	//Agrega a la lista de atributos todos los atributos.
	public void setAtributos(int velocidad, int fuerza, int resistencia, int destreza) {

		atributos.add(new Atributo(Caracteristica.VELOCIDAD, velocidad));
		atributos.add(new Atributo(Caracteristica.FUERZA, fuerza));
		atributos.add(new Atributo(Caracteristica.RESISTENCIA, resistencia));
		atributos.add(new Atributo(Caracteristica.DESTREZA, destreza));
	}

	@Override
	public String toString() {

		return "Competidor: " + nombrePersonaje + ". Nombre Real: " + nombreReal + ". Atributos: " + atributos + ".";
	}
	
	/**
	 * 
	 * Se inicia el enfrentamiento vs otro personaje por caracteristica.
	 * Utiliza el método recorrerAtributosDesdePosicion(), tomando como posición 
	 * el resultado de obtenerPosicionCaracteristica().
	 * 
	 */
	public int competir(Personaje personaje, Caracteristica caracteristica) {

		int posicion = obtenerPosicionCaracteristica(caracteristica);
		
		if(recorrerAtributosDesdePosicion(personaje, posicion) == 0) {
			
			return recorrerAtributosDesdePosicion(personaje, 0);
		}

		return recorrerAtributosDesdePosicion(personaje, posicion);
	}
	
	/**
	 * 
	 * 
	 */
	public boolean esGanador(Personaje personaje, Caracteristica caracteristica) {
		
		return competir(personaje, caracteristica) == 1;
	}
	
	private int obtenerPosicionCaracteristica(Caracteristica caracteristica) {

		int posicion = 0;
		ListIterator<Atributo> iterator = atributos.listIterator();

		while (iterator.hasNext()) {

			Atributo aux = iterator.next();

			if (aux.getCaracteristica().equals(caracteristica)) {
				posicion = atributos.indexOf(aux);
			}
		}

		return posicion;
	}

	private int recorrerAtributosDesdePosicion(Personaje personaje, int posicion) {

		int contador = 0;
		ListIterator<Atributo> itrPersonaje = atributos.listIterator(posicion);
		ListIterator<Atributo> itrContrincante = personaje.atributos.listIterator(posicion);

		while (itrPersonaje.hasNext() && contador != 4) {

			Atributo auxPersonaje = itrPersonaje.next();
			Atributo auxContrincante = itrContrincante.next();

			if (auxPersonaje.compareTo(auxContrincante) == 0) {
				
				contador++;
			} else {
				
				return auxPersonaje.compareTo(auxContrincante);
			}
		}
		
		return 0;
	}
}
