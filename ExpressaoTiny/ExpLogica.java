package ExpressaoTiny;

//------------Classe ExpLogica----------------------
public class ExpLogica extends Expressao {

	private Expressao v1;
	private Expressao v2;

	private OpLogico op;

	public ExpLogica(Expressao v1, Expressao v2, OpLogico op) {
		this.v1 = v1;
		this.v2 = v2;
		this.op = op;
	}

	@Override
	public int intAvalia() {
		switch (op) {
		case maior:
			return v1.intAvalia() > v2.intAvalia() ? 1 : 0;
		case menor:
			return v1.intAvalia() < v2.intAvalia() ? 1 : 0;
		case igual:
			return v1.intAvalia() == v2.intAvalia() ? 1 : 0;
		case diferente:
			return v1.intAvalia() != v2.intAvalia() ? 1 : 0;
		default:
			return 0;
		}
	}
	
}
