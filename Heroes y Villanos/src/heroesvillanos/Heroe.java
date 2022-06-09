package heroesvillanos;

public class Heroe extends Personaje {

	public Heroe(String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia, int destreza) {

		super(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
	}
	
	@Override
	public String toString() {
		
		return super.toString() + " HEROE.";
	}
}
