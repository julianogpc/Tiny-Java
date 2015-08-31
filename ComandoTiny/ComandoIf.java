package ComandoTiny;

import ExpressaoTiny.Expressao;

//------------Classe ComandoIf----------------------
public class ComandoIf extends Comando {

	private Expressao teste;
	@SuppressWarnings("unused")
	private int linhaEndIf;
	private int linhaElse;

	public ComandoIf(Expressao teste, int linha) {
		this.teste = teste;
		this.linha = linha;
	}

	@Override
	public int executa() {
		if (teste.intAvalia() == 1)
			return linha + 1;
		else
			return linhaElse + 1;
	}

	public int getLinhaEndIf() {
		return linhaEndIf;
	}

	public void setLinhaEndIf(int linhaEndIf) {
		this.linhaEndIf = linhaEndIf;
	}

	public int getLinhaElse() {
		return linhaElse;
	}

	public void setLinhaElse(int linhaElse) {
		this.linhaElse = linhaElse;
	}
	
}
