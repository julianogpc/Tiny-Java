   package ExpressaoTiny;

//------------Classe ExpSqrt----------------------
    public class ExpSqrt extends Expressao {
      private Expressao valor;
   
       public ExpSqrt(Expressao valor) {
         this.valor = valor;
      }
   
       @Override
       public int intAvalia() {
         return (int) Math.sqrt(valor.intAvalia());
      }
   
   }
