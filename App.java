import java.util.Hashtable;

public class App {

	public static void main(String[] args) throws Exception {

		//Entrada e Saida do texto a ser Codificado
		DataIO io = new DataIO();

		//Recebe uma String (do texto) e gera uma tabela de frequencia de caracteres
		FreqTable table = new FreqTable(io.read(args[0]));

		//Recebe a tabela de frequencia de caracteres e cria a codificação correspondente
		HuffmanEncoding hf = new HuffmanEncoding(table.get());

		// hf.printEncoding();

		//Criei o gerador
		Gerador g = new Gerador();

		// System.out.println(g.codifica(hf.codeTable(), io.read(args[0])));

// io.write("textC", g.codifica(hf.codeTable(), io.read(args[0])));

io.write("textD", g.decodifica(io.read(args[0])));

		//Recebe o texto e a codificação e gera o texto novo
// GERADOR =HuffmanEncoding (recebe um hashtable CHAR + CODIGO)
// USAR O GERADOR PARA MONTAR O TEXTO
// DATAIO CRIA TXT DO GERADOR (STRING)

		//Recebe um texto codificado e volta ao normal

	}

}
