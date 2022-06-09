package heroesvillanos;

public class Villano extends Personaje {

	public Villano(String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia, int destreza) {

		super(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
	}

	@Override
	public String toString() {
		
		return super.toString() + " VILLANO.";
	}
}
