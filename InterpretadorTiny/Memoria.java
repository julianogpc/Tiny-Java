   package InterpretadorTiny;

   import java.util.Hashtable;
   import ExpressaoTiny.Variavel;

//------------Classe Memoria----------------------
    public class Memoria {
   
      private Hashtable<String, Variavel> T;
   
       public Memoria() {
         T = new Hashtable<String, Variavel>();
      }
   
       public Variavel getVarialvel(String varNome) {
         Variavel var = T.get(varNome);
      
         if (var != null)
            return var;
      
         var = new Variavel(varNome);
         T.put(var.getVarNome(), var);
         return var;
      }
   
       public void setVarialvel(Variavel var) {
         T.put(var.getVarNome(), var);
      }
		 
   }
