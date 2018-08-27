//Objetivo ? recebe um texto qualquer, gera uma
//tabela de frequencia de ocorrencias de caracteres

import java.util.Hashtable;

public class FreqTable {

	private Hashtable<Character,Double> table;

	public FreqTable (String texto) {
    table = new Hashtable<Character,Double>();

		for (int i = 0; i<texto.length(); i++) {
			put(texto.charAt(i));
		}
  }

	public void put(Character s) {
		if(!table.containsKey(s)) table.put(s,(double) 0);
		else table.put(s,table.get(s)+1);
	}

	public Hashtable<Character,Double> envia(){
		return table;
	}
}
