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
// System.out.println(texto);
      Hashtable<String, Character> cod = new Hashtable<String, Character>();
      boolean criouHash = false;
      char caractere = ' ';
      String codigo = "";
      String novotexto = "";
      for (int i = 0; i < texto.length(); i++) {
// System.out.println("entrou = " + texto.charAt(i));
        //enquanto nao terminou de ler os codigos criouhash = false
        if(!criouHash) {
          if(texto.charAt(i) == '^') {
            if(!codigo.equals("")) {
// System.out.println("["+i+"] Se for ^ e code tem coisa entao salva: [ "+ caractere +" ] " + codigo);
              cod.put(codigo, caractere);
              codigo = "";
            }
            if(texto.charAt(i+1) == '-') {
              caractere = texto.charAt((i+3));
// System.out.println("["+i+"] Se for ^- pega caractere: " + caractere);
              i+=3;

            } else /* se nao for ^-^ entao tem que ser ^+^ */ {
              //neste caso quero começar a criar o texto
              i+=2;

// System.out.println("["+i+"] Se for ^+ FAZ i+2 e avança logo para o caractere: " + texto.charAt(i));
              codigo = "";
              criouHash = true;
            }
          } else /* neste caso estamos lendo o codigo */ {
            codigo += texto.charAt(i);
          }
        } else /*(!criouHash)*/ {
          //aqui tem que traduzir o texto usando a hashtable criada
          codigo += texto.charAt(i);
// System.out.println("["+i+"] entrei na area codificada, lendo: " + texto.charAt(i) + " // codigo atual: " + codigo);
// System.out.println(codigo + " " + cod.get(codigo));
          if(cod.get(codigo) != null) {
            novotexto += cod.get(codigo);
            codigo = "";
          }
        }
      }
      return novotexto;
    }

}
