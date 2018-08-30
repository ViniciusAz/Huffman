
import java.io.*;

public class DataIO {

  FileReader fr;
  FileWriter fw;

  public DataIO() {
  }

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
    return texto;
  }

  public void write(String file, String texto) throws Exception{
    fw = new FileWriter(new File(file+"x"));
    fw.write(texto);
    fw.close();
  }

}
