import java.util.Hashtable;

public class App {

	public static void main(String[] args) throws Exception {

		//Entrada e Saida do texto a ser Codificado
		DataIO io = new DataIO();

		//Recebe uma String (do texto) e gera uma tabela de frequencia de caracteres
		FreqTable table = new FreqTable(io.read(args[0]));

		//Recebe a tabela de frequencia de caracteres e cria a codificação correspondente
		HuffmanEncoding hf = new HuffmanEncoding(table.get());

		hf.printEncoding();

		//Recebe o texto e a codificação e gera o texto novo

		//Recebe um texto codificado e volta ao normal


	}

}
