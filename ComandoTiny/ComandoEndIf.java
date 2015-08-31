package ComandoTiny;

//------------Classe ComandoEndIf----------------------
public class ComandoEndIf extends Comando {

	public ComandoEndIf(int linha) {
		this.linha = linha;
	}

	@Override
	public int executa() {
		return linha + 1;
	}
	
}
