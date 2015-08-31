package ComandoTiny;

//------------Classe ComandoEndW----------------------
public class ComandoEndW extends Comando {

	private int linhaWhile;

	public ComandoEndW(int linhaWhile, int linha) {
		this.linha = linha;
		this.linhaWhile = linhaWhile;
	}

	@Override
	public int executa() {
		return linhaWhile;
	}

}
