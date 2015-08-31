package ComandoTiny;

import ExpressaoTiny.ExpLogica;
import ExpressaoTiny.Expressao;
import ExpressaoTiny.OpLogico;
import ExpressaoTiny.Variavel;

//------------Classe ComandoFor----------------------
public class ComandoFor extends Comando {

	private Expressao teste;

	private Variavel var;

	private Expressao exp1;

	private Expressao exp2;

	private int fimFor;

	public ComandoFor(Variavel var, Expressao exp1, Expressao exp2, int linha) {
		this.var = var;
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.linha = linha;
		this.teste = null;
	}

	@Override
	public int executa() {
		if (teste == null){
			var.setValor(exp1.intAvalia());
			teste = new ExpLogica(var, exp2, OpLogico.maior);
		}

		if (teste.intAvalia() == 0)
			return linha + 1;
		else
		{
			teste = null;
			return fimFor + 1;
		}
	}

	public void setFimFor(int fimFor) {
		this.fimFor = fimFor;
	}

	public int getLinhaFor() {
		return linha;
	}

}
