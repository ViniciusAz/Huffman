
import java.io.*;

public class DataIO {

  FileReader fr;

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

  public boolean write(String file, String texto) throws Exception{
    //TO DO
    return false;
  }


}
