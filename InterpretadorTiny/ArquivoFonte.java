   package InterpretadorTiny;

   import java.io.*;
   import java.util.StringTokenizer;

//------------ArquivoFonte----------------------
    public class ArquivoFonte {
   
      private FileReader arq;
      private BufferedReader dados;
      private String linha;
      private StringTokenizer st;
      private static String delim = "+-*/()=<> ';!";
      private boolean em_string = false;
   
       public ArquivoFonte(String name) {
      
         try {
            arq = new FileReader(name);
            dados = new BufferedReader(arq);
            linha = dados.readLine();
            if (linha == null)
               st = null;
            else
               st = new StringTokenizer(linha, delim, true);
         } 
             catch (Exception e) {
               System.out.println(e);
            }
      }
   
       public String proximaPalavra() {
      
         if (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.equals("'"))
               em_string = !em_string;
            if (s.equals(" ") && (!em_string))
               return proximaPalavra();
            if (s.equals("\\b"))
               return " ";
            if (s.equals("!")) {
               String s2 = st.nextToken();
               String opDiferente = s + s2;
               if (opDiferente.equals("!="))
                  return (opDiferente);
               else {
                  System.out.println("String invalido: " + opDiferente);
                  System.exit(0);
                  return s2;
               }
            } 
            else
               return s;
         } 
         else {
            try {
               linha = dados.readLine();
               if (linha == null)
                  return "EOF";
               else {
                  st = new StringTokenizer(linha, delim, true);
                  return proximaPalavra();
               }
            } 
                catch (Exception e) {
                  System.out.println(e);
               }
            return "EOF";
         }
      }
   
       public void saltaPalavra() {
         @SuppressWarnings("unused")
            String s = proximaPalavra();
      }
   
   }
