package ComandoTiny;

//------------Classe ComandoStr----------------------
public class ComandoWriteStr extends Comando {
	private String msg;

	public ComandoWriteStr(String msg, int linha) {
		this.linha = linha;
		this.msg = msg;
	}

	@Override
	public int executa() {
		System.out.print(msg);
		return linha + 1;
	}

}
