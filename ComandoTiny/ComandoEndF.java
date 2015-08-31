package ComandoTiny;

import ExpressaoTiny.Variavel;

//------------Classe ComandoEndF----------------------
public class ComandoEndF extends Comando {

	private Variavel var;

	private int linhaFor;

	public ComandoEndF(Variavel var, int linhaFor, int linha) {
		this.var = var;
		this.linhaFor = linhaFor;
		this.linha = linha;
	}

	@Override
	public int executa() {
		int incremento = var.getValor() + 1;
		var.setValor(incremento);
		return linhaFor;
	}

	public void setLinhaFor(int linhaFor) {
		this.linhaFor = linhaFor;
	}

}
