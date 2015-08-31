   package InterpretadorTiny;

   import java.util.Stack;
   import java.util.Vector;

   import ComandoTiny.*;
   import ExpressaoTiny.*;

//------------Classe Interpretador----------------------
    public class Interpretador {
      private ArquivoFonte arq;
   
      private Vector<Comando> comandos;
   
      private Memoria memo;
   
      private Stack<Comando> pilhaComandos;
   
      private Stack<Variavel> pilhaVariavel;
   
       public Interpretador(String nome) {
         arq = new ArquivoFonte(nome);
         comandos = new Vector<Comando>();
         memo = new Memoria();
         pilhaComandos = new Stack<Comando>();
         pilhaVariavel = new Stack<Variavel>();
      }
   
       public void leArquivo() {
      
         String comandoAtual;
         int linha = 0;
         do {
            comandoAtual = arq.proximaPalavra();
            if (comandoAtual.equals("endp"))
               trataComandoEndp(linha);
            
            else if (comandoAtual.equals("writeStr"))
               trataComandoWriteStr(linha);
            
            else if (comandoAtual.equals("writeVar"))
               trataComandoWriteVar(linha);
            
            else if (comandoAtual.equals("writeln"))
               trataComandoWriteLn(linha);
            
            else if (comandoAtual.equals("read"))
               trataComandoRead(linha);
            
            else if (comandoAtual.equals("if"))
               trataComandoIf(linha);
            
            else if (comandoAtual.equals("else"))
               trataComandoElse(linha);
            
            else if (comandoAtual.equals("endif"))
               trataComandoEndIf(linha);
            
            else if (comandoAtual.equals("while"))
               trataComandoWhile(linha);
            
            else if (comandoAtual.equals("endw"))
               trataComandoEndW(linha);
            
            else if (comandoAtual.equals("for"))
               trataComandoFor(linha);
            
            else if (comandoAtual.equals("endf"))
               trataComandoEndF(linha);
            
            else
               trataComandoAtrib(linha, comandoAtual);
         
            linha++;
         } while (!comandoAtual.equals("endp"));
      }
   
       private void trataComandoAtrib(int lin, String varNome) {
         Variavel var;
         String token;
         Expressao exp;
      
         var = memo.getVarialvel(varNome);
      
         token = arq.proximaPalavra() + arq.proximaPalavra();
         testarSintaxe(4, token);
      
         exp = gerarExpressao();
      
         ComandoAtrib c = new ComandoAtrib(var, exp, lin);
         comandos.addElement(c);
      }
   
       private void trataComandoElse(int lin) {
         ComandoIf cmdIf = (ComandoIf) pilhaComandos.peek();
         cmdIf.setLinhaElse(lin);
      
         ComandoElse c = new ComandoElse(lin);
         comandos.addElement(c);
         pilhaComandos.push(c);
      }
   
       private void trataComandoEndF(int lin) {
         ComandoFor cmdFor = (ComandoFor) pilhaComandos.pop();
         cmdFor.setFimFor(lin);
      
         Variavel var = pilhaVariavel.pop();
      
         ComandoEndF c = new ComandoEndF(var, cmdFor.getLinhaFor(), lin);
         comandos.addElement(c);
      }
   
       private void trataComandoEndIf(int lin) {
         ComandoIf cmdIf;
      
         if (!pilhaComandos.empty()
         	&& pilhaComandos.peek() instanceof ComandoElse) {
            ComandoElse cmdElse = (ComandoElse) pilhaComandos.pop();
         
            cmdElse.setLinhaEndIf(lin);
         }
         cmdIf = (ComandoIf) pilhaComandos.pop();
      
         cmdIf.setLinhaEndIf(lin);
      
         if (cmdIf.getLinhaElse() == -1)
            cmdIf.setLinhaElse(lin);
      
         ComandoEndIf c = new ComandoEndIf(lin);
         comandos.addElement(c);
      }
   
       private void trataComandoEndp(int lin) {
      
         ComandoEndp c = new ComandoEndp(lin);
         comandos.addElement(c);
      }
   
       private void trataComandoEndW(int lin) {
         ComandoWhile cmdWhile = (ComandoWhile) pilhaComandos.pop();
         cmdWhile.setLinhaFimWhile(lin);
      
         ComandoEndW c = new ComandoEndW(cmdWhile.getLinhaWhile(), lin);
         comandos.addElement(c);
      }
   
       private void trataComandoFor(int lin) {
         String token;
         Expressao exp1, exp2;
         Variavel var;
      
         token = arq.proximaPalavra();
      
         var = memo.getVarialvel(token);
         pilhaVariavel.push(var);
      
         token = arq.proximaPalavra() + arq.proximaPalavra();
         testarSintaxe(4, token);
      
         exp1 = gerarExpressao();
         exp2 = gerarExpressao();
      
         ComandoFor c = new ComandoFor(var, exp1, exp2, lin);
         comandos.addElement(c);
         pilhaComandos.push(c);
      }
   
       private void trataComandoIf(int lin) {
         Expressao exp = gerarExpressao();
      
         ComandoIf c = new ComandoIf(exp, lin);
         comandos.addElement(c);
      
         pilhaComandos.push(c);
      
         c.setLinhaElse(-1);
      }
   
       private void trataComandoRead(int lin) {
         Variavel var;
         String token;
      
         token = arq.proximaPalavra();
         testarSintaxe(1, token);
      
         token = arq.proximaPalavra();
      
         var = memo.getVarialvel(token);
      
         token = arq.proximaPalavra();
         testarSintaxe(2, token);
         token = arq.proximaPalavra();
         testarSintaxe(3, token);
      
         ComandoRead c = new ComandoRead(var, lin);
         comandos.addElement(c);
      }
   
       private void trataComandoWhile(int lin) {
         Expressao exp = gerarExpressao();
      
         ComandoWhile c = new ComandoWhile(exp, lin);
         comandos.addElement(c);
      
         pilhaComandos.push(c);
      }
   
       private void trataComandoWriteLn(int lin) {
         String token;
      
         token = arq.proximaPalavra();
         testarSintaxe(3, token);
      
         ComandoWriteLn c = new ComandoWriteLn(lin);
         comandos.addElement(c);
      }
   
       private void trataComandoWriteStr(int lin) {
         String msg = "";
         String token;
      
         token = arq.proximaPalavra();
         testarSintaxe(1, token);
      
         token = arq.proximaPalavra();
         while (!token.equals(")")) {
            msg = msg + token + " ";
            token = arq.proximaPalavra();
         }
      
         token = arq.proximaPalavra();
         testarSintaxe(3, token);
      
         ComandoWriteStr c = new ComandoWriteStr(msg, lin);
         comandos.addElement(c);
      }
   
       private void trataComandoWriteVar(int lin) {
         Variavel var;
         String token;
      
         token = arq.proximaPalavra();
         testarSintaxe(1, token);
      
         token = arq.proximaPalavra();
         var = memo.getVarialvel(token);
      
         token = arq.proximaPalavra();
         testarSintaxe(2, token);
         token = arq.proximaPalavra();
         testarSintaxe(3, token);
      
         ComandoWriteVar c = new ComandoWriteVar(var, lin);
         comandos.addElement(c);
      }
   
       private Expressao gerarExpressao() {
         Stack<Expressao> p = new Stack<Expressao>();
         Expressao exp = null;
         Expressao elem = null;
         String comandoAtual = arq.proximaPalavra();
      
         while (!comandoAtual.equals(";") && !comandoAtual.equals("then")
         	&& !comandoAtual.equals("to") && !comandoAtual.equals("do")) {
         
            if (isNumber(comandoAtual)) {
               exp = new Constante(cInt(comandoAtual));
            } 
            else if (comandoAtual.equals("sqrt")) {
               exp = new ExpSqrt(p.pop());
            } 
            else if (comandoAtual.equals("+")) {
               elem = p.pop();
               exp = new ExpBinaria(p.pop(), elem, OpAritmetico.sum);
            } 
            else if (comandoAtual.equals("-")) {
               elem = p.pop();
               exp = new ExpBinaria(p.pop(), elem, OpAritmetico.sub);
            } 
            else if (comandoAtual.equals("*")) {
               elem = p.pop();
               exp = new ExpBinaria(p.pop(), elem, OpAritmetico.mul);
            } 
            else if (comandoAtual.equals("/")) {
               elem = p.pop();
               exp = new ExpBinaria(p.pop(), elem, OpAritmetico.div);
            } 
            else if (comandoAtual.equals("=")) {
               elem = p.pop();
               exp = new ExpLogica(p.pop(), elem, OpLogico.igual);
            } 
            else if (comandoAtual.equals(">")) {
               elem = p.pop();
               exp = new ExpLogica(p.pop(), elem, OpLogico.maior);
            } 
            else if (comandoAtual.equals("<")) {
               elem = p.pop();
               exp = new ExpLogica(p.pop(), elem, OpLogico.menor);
            } 
            else if (comandoAtual.equals("!=")) {
               elem = p.pop();
               exp = new ExpLogica(p.pop(), elem, OpLogico.diferente);
            } 
            else if (!comandoAtual.equals(";")
            	&& !comandoAtual.equals("then")
            	&& !comandoAtual.equals("to") && !comandoAtual.equals("do")) {
               exp = memo.getVarialvel(comandoAtual);
            }
            p.push(exp);
            comandoAtual = arq.proximaPalavra();
         }
      
         return p.pop();
      }
   
       private boolean isNumber(String str) {
         for (int i = 0; i < str.length(); i++)
            if (!Character.isDigit(str.charAt(i)))
               return false;
         return true;
      }
   
       private void testarSintaxe(int opt, String token) {
      
         String opcoes[] = { "(", ")", ";", ":=" };
      
         if (opt > 0 && opt < 4 && !token.equals(opcoes[opt - 1]))
            throw new RuntimeException("Erro de sintaxe! (" + token + ")");
      }
   
       private int cInt(String str) {
         int valor = 0;
         valor = Integer.parseInt(str);
         return valor;
      }
   
       public void executa() {
      
         Comando cmd;
         int pc = 0;
         do {
            cmd = (Comando) comandos.elementAt(pc);
            pc = cmd.executa();
         } while (pc != -1);
      }
   
   }