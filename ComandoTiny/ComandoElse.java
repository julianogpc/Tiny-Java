package ComandoTiny;

//------------Classe ComandoElse----------------------
public class ComandoElse extends Comando {
	private int linhaEndIf;

	@SuppressWarnings("unused")
	public ComandoElse(int linha) {
		this.linha = linha;
	}

	@Override
	public int executa() {
		return linhaEndIf;
	}

	public void setLinhaEndIf(int linhaEndIf) {
		this.linhaEndIf = linhaEndIf;
	}
	
}
