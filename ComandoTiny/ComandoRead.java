package ComandoTiny;

import ExpressaoTiny.Variavel;
import InterpretadorTiny.Console;

//------------Classe ComandoRead----------------------
public class ComandoRead extends Comando {
	private Variavel var;
	private int valor;

	public ComandoRead(Variavel var, int linha) {
		this.linha = linha;
		this.var = var;
	}

	@Override
	public int executa() {
		valor = Console.readInt();
		var.setValor(valor);
		return linha + 1;
	}
	
}
