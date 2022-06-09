package heroesvillanos;

public class Demo {

	public static void main(String[] args) {
		
		Personaje heroe = new Heroe("Edward Blake", "The Comedian", 100, 110, 100, 100);
		Personaje villano = new Villano("Adrian Veidt", "Ozymandias", 110, 100, 100, 100);
		
//		System.out.println(heroe);
//		System.out.println(villano);
		
//		System.out.println(heroe.obtenerPosicionCaracteristica(Caracteristica.VELOCIDAD));
//		
//		System.out.println(heroe.recorrerAtributosDesdePosicion(villano, 0));
		
		System.out.println(heroe.competir(villano, Caracteristica.VELOCIDAD));
		System.out.println(heroe.esGanador(villano, Caracteristica.VELOCIDAD));
		
		System.out.println("Esto es un syso de prueba");
	}

}
