   package ComandoTiny;

   import ExpressaoTiny.Expressao;

//------------Classe ComandoWhile----------------------
    public class ComandoWhile extends Comando {
   
      private Expressao teste;
      private int linhaFimWhile;
   
       public ComandoWhile(Expressao teste, int linha) {
         this.linha = linha;
         this.teste = teste;
      }
   
       @Override
       public int executa() {
         if (teste.intAvalia() == 1)
            return linha + 1;
         else
            return linhaFimWhile + 1;
      }
   
       public void setLinhaFimWhile(int linhaFimWhile) {
         this.linhaFimWhile = linhaFimWhile;
      }
   
       public int getLinhaWhile() {
         return linha;
      }
   
   }
