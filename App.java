import java.util.Hashtable;
import java.io.*;

public class App {

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader(new File(args[0]));
		String texto = "";
		int i = fr.read();
		while(i != -1)
		{
			texto += (char)i;
			i = fr.read();
		}
		fr.close();

		FreqTable table = new FreqTable(texto);

		HuffmanEncoding hf = new HuffmanEncoding(table.envia());

		hf.printEncoding();

	}

}
