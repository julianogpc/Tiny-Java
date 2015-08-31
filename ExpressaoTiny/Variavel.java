   package ExpressaoTiny;
   
//------------Classe Variavel----------------------
    public class Variavel extends Expressao {
      private int valor;
      private String var;
   
       public Variavel(String var) {
         this.var = var;
         this.valor = 0;
      }
   
       public int getValor() {
         return valor;
      }
   
       public void setValor(int valor) {
         this.valor = valor;
      }
   
       public String getVarNome() {
         return var;
      }
   
       @Override
       public int intAvalia() {
         return valor;
      }
		
   }
