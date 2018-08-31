
import java.io.*;

public class DataIO {

  FileReader fr;
  FileWriter fw;

  public DataIO() {
  }

  //Recebe nome do arquivo como parametro e retorna uma string com conteudo
  public String read(String file) throws Exception{
    fr = new FileReader(new File(file));
    String texto = "";
    int i = fr.read();
    while(i != -1)
    {
      texto += (char)i;
      i = fr.read();
    }
    fr.close();
    System.out.println("Arquivo de Entrada : " + file);
    return texto;
  }

  //Recebe um Texto como parametro e cria um arquivo com o texto como conteudo
  public void write(String file, String texto) throws Exception{
    fw = new FileWriter(new File(file));
    fw.write(texto);
    System.out.println("Arquivo de Saída : " + file);
    fw.close();
  }

}
