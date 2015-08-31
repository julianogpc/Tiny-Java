   import InterpretadorTiny.Interpretador;

//------------Classe Tiny----------------------
    public class Tiny {
   
       public static void main(String[] args) {
         Interpretador inter;
         if (args.length == 1) {
            inter = new Interpretador(args[0]);
            inter.leArquivo();
            inter.executa();
         } 
         else
            System.out.println("Indique o programa a ser interpretado");
      }
   }