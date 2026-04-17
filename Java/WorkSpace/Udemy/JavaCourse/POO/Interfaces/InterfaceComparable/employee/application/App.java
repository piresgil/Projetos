/*
 *  @ Daniel Gil
 */

package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
  /*
  *  
  */
  public static void main(String[] args) {
    // lista para percorer linhas do arquivo
    List<String> list = new ArrayList<>();
    // caminho do arquivo
    String path = "C:\\temp\\in.txt";
    // instancia o befferReader do caminho do arquivo
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String name = br.readLine(); // armazena numa var a leitura de uma linha
      while (name != null) {
        list.add(name);// adiciona na lista
        name = br.readLine();// le uma nova linha
      }
      // Collections.sort é uma forma de ordenar coleções(listas...)
      // forma padrão de ordenar coleções
      Collections.sort(list);// ordena a lista por ordem alfabetica
      for (String s : list)
        System.out.println(s);
      { // impresao de arquivo via terminal
      }
    } catch (IOException e) { // tratamento de IOEXecption
      System.out.println("Error: " + e.getMessage());
    }
  }
}
