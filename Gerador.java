import java.util.Hashtable;
import java.util.Set;

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

  public String Decodifica() {
    return null;
  }

}
