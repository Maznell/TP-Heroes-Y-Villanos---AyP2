package heroesvillanos;

public class Atributo implements Comparable<Atributo> {
	
	private Caracteristica nombre;
	private int valor;
	
	public Atributo(Caracteristica nombre, int valor) {
		
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public Caracteristica getCaracteristica() {
		
		return nombre;
	}
	
	public int getValor() {
		
		return valor;
	}
	
	@Override
	public int compareTo(Atributo o) {
		
		return Integer.compare(getValor(), o.getValor());
	}
	
	@Override
	public String toString() {
		
		return nombre + ": " + valor;
	}
	
	public static void main(String[] args) {
		
		Atributo atributo = new Atributo(Caracteristica.FUERZA, 200);
		
		System.out.println(atributo);
	}

}
