   package ExpressaoTiny;

//------------Classe ExpBinaria----------------------
    public class ExpBinaria extends Expressao {
      private Expressao v1;
      private Expressao v2;
   
      private OpAritmetico op;
   
       public ExpBinaria(Expressao v1, Expressao v2, OpAritmetico op) {
         this.v1 = v1;
         this.v2 = v2;
         this.op = op;
      }
   
       @Override
       public int intAvalia() {
         switch (op) {
            case sum:
               return v1.intAvalia() + v2.intAvalia();
            case sub:
               return v1.intAvalia() - v2.intAvalia();
            case mul:
               return v1.intAvalia() * v2.intAvalia();
            case div:
               return v1.intAvalia() / v2.intAvalia();
            default:
               return 0;
         }
      }
      
   }
