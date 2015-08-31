package ComandoTiny;

import ExpressaoTiny.*;

//------------Classe ComandoAtrib----------------------
public class ComandoAtrib extends Comando {
	private Variavel var;

	private Expressao exp;

	public ComandoAtrib(Variavel var, Expressao exp, int linha) {
		this.var = var;
		this.linha = linha;
		this.exp = exp;
	}

	public int executa() {
		int valor = 0;
		valor = exp.intAvalia();
		var.setValor(valor);
		return linha + 1;
	}
	
}
