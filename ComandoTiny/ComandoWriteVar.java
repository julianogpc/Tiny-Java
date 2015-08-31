package ComandoTiny;

import ExpressaoTiny.Variavel;

//------------Classe ComandoWriteVar----------------------
public class ComandoWriteVar extends Comando {
	private Variavel var;

	public ComandoWriteVar(Variavel var, int linha) {
		this.linha = linha;
		this.var = var;
	}

	@Override
	public int executa() {
		System.out.print(var.getValor());
		return linha + 1;
	}

}
