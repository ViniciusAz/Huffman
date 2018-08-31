import java.util.Hashtable;
import java.util.Set;

//Gerador = Gera um novo texto
//Quando Codificado ele gera novo texto Decodificado e vice-versa

public class Gerador {

Hashtable<Character, Double> ht;

  public Gerador() {
    ht = new Hashtable<Character, Double>();
  }

  //Recebe por parametro a Tabela de Character x Code
  //Escreve na saida ^-^CharCode^-^CharCode...
  //Escreve o texto logo em seguida ...^-^CharCode^+^texto...
  //Exemplo de saida : ^-^a01^-^b11^-^c100^+^100011101 (texto = caba)
  public String codifica(Hashtable h, String t) {
    String r = "";
    Set<Character> keys = h.keySet();
    for (Character e : keys) {
      r+= "^-^" + e + h.get(e);
		}
    r+="^+^";
    for (int i = 0; i < t.length(); i++) {
      //incrementa r com o codigo correspondete a cada caractere do texto
      r+=h.get(t.charAt(i));
    }
    return r;
  }

    //Primeiramente pegar todos os codigos delimitados no inicio do TEXTO
    //Criar uma nova hashtable com os caracteres e seus codigos correspondentes
    //depois usar a hashtable como auxiliar para traduzir o texto.
    public String decodifica(String texto) {
      Hashtable<String, Character> cod = new Hashtable<String, Character>();
      boolean criouHash = false;
      char caractere = ' ';
      String codigo = "";
      String novotexto = "";
      for (int i = 0; i < texto.length(); i++) {
        //enquanto nao terminou de ler os codigos criouhash = false
        if(!criouHash) {
          if(texto.charAt(i) == '^') {
            if(!codigo.equals("")) {
              cod.put(codigo, caractere);
              codigo = "";
            }
            if(texto.charAt(i+1) == '-') {
              caractere = texto.charAt((i+3));
              i+=3;

            } else /* se nao for ^-^ entao tem que ser ^+^ */ {
              //neste caso quero começar a criar o texto
              i+=2;

              codigo = "";
              criouHash = true;
            }
          } else /* neste caso estamos lendo o codigo */ {
            codigo += texto.charAt(i);
          }
        } else /*(!criouHash)*/ {
          //aqui tem que traduzir o texto usando a hashtable criada
          codigo += texto.charAt(i);
          if(cod.get(codigo) != null) {
            novotexto += cod.get(codigo);
            codigo = "";
          }
        }
      }
      return novotexto;
    }

}
