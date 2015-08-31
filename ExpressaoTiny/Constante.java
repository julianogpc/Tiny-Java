package ExpressaoTiny;

//------------Classe Constante----------------------
public class Constante extends Expressao {
	private int valor;

	public Constante(int valor) {
		this.valor = valor;
	}

	@Override
	public int intAvalia() {
		return valor;
	}
	
}
