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

import entities.Employee;

public class AppPart2 {
  /*
  * 
  */
  public static void main(String[] args) {
    // lista para percorer linhas do arquivo
    List<Employee> list = new ArrayList<>();
    // caminho do arquivo
    String path = "C:\\temp\\Emplyee.txt";
    // instancia o befferReader do caminho do arquivo
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String employeCsv = br.readLine(); // armazena numa var a leitura de uma linha
      while (employeCsv != null) {

        String[] fields = employeCsv.split(",");// recorta a string

        list.add(new Employee(fields[0], Double.parseDouble(fields[1])));// adiciona na lista
        employeCsv = br.readLine();// le uma nova linha
      }
      // Collections.sort é uma forma de ordenar coleções(listas...)
      // forma padrão de ordenar coleções
      Collections.sort(list);// ordena a lista por ordem alfabetica
      for (Employee emp : list)
        System.out.println(emp.getName() + ", " + emp.getSalary());
      { // impresao de arquivo via terminal
      }
    } catch (IOException e) { // tratamento de IOEXecption
      System.out.println("Error: " + e.getMessage());
    }
  }
}