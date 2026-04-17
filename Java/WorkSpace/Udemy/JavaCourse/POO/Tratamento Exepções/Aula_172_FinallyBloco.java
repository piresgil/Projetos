/*
 *  @ Daniel Gil
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Aula_172_FinallyBloco {
  /*
  *  
  */
  public static void main(String[] args) {

    File file = new File("C:\\temp\\in.txt");
    Scanner sc = null; // scanner para ler arquivo

    try {
      sc = new Scanner(file);
      while (sc.hasNextLine()) {
        System.out.println(sc.nextLine());
      }

    } catch (IOException e) {
      System.out.println("Error opening file: " + e.getMessage());
    }

    // Independentemente de dar exceção ou não executa o bloco finally

    finally { // bloco finally fecha o scanner(leitura de arquivos)
      if (sc != null) {
        sc.close();
      }
      System.out.println("finally bock executed");
    }
  }
}