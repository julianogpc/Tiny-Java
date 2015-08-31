package ComandoTiny;

//------------Classe Abstrata Comando----------------------
public abstract class Comando {
	protected int linha;
	public abstract int executa();
}
