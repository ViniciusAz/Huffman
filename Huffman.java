import java.util.Hashtable;

public class Huffman {

  //Criei o gerador para criar a saida
  //g.codifica = recebe texto e tabela de simbolos/codigos e gera o texto codificado
  //g.decoficica = recebe o texto e gera ele decoficado
  private Gerador g;
  private String textoOriginal;
  public Huffman (String s) {
    g = new Gerador();
    textoOriginal = s;
  }

  public String processa () {
    //Verifica os dois primeiros caracteres, se for ^- vou chamar DECODIFICADOR
    if((textoOriginal.charAt(0) + "" + textoOriginal.charAt(1)).equals("^-")) {
      //Retorna Gerador -> Decodifica (TEXTO)
      return g.decodifica(textoOriginal);
    } else /* Neste caso, faço o processo de CODIFICAR */ {

      //Recebe uma String (do texto) e gera uma tabela de frequencia de caracteres
    	FreqTable table = new FreqTable(textoOriginal);

    	//Recebe a tabela de frequencia de caracteres e cria a codificação correspondente
    	HuffmanEncoding hf = new HuffmanEncoding(table.get());

      //Retorna a chamada do Gerador -> codifica (tabela de codigos, TEXTO)
      return g.codifica(hf.codeTable(), textoOriginal);
    }
  }
}
