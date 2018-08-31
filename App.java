
public class App {

	public static void main(String[] args) throws Exception {

		//Entrada e Saida do texto a ser Codificado
		DataIO io = new DataIO();

		String arquivo = args[0];

		//Cria huffman lendo o arquivo
		Huffman huff = new Huffman(io.read(arquivo));

		//Chama o gerador de saídas com parametro (nome do arquivo (novo) e aplica o huffman para o arquivo)
		io.write((arquivo + "new"), huff.processa());


	}

}
