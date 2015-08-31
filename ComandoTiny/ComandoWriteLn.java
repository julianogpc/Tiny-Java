package ComandoTiny;

//------------Classe ComandoWriteLn----------------------
public class ComandoWriteLn extends Comando {

	public ComandoWriteLn(int linha) {
		this.linha = linha;
	}

	@Override
	public int executa() {
		System.out.println();
		return linha + 1;
	}

}
