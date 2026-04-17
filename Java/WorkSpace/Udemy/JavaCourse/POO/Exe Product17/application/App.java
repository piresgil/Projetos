/*
 *  @ Daniel Gil
 */

package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product17;

public class App {
    /*
    *  
    */
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        List<Product17> list = new ArrayList<>();

        System.out.print("Enter path: ");
        // String sourceFiles =sc.nextLine();
        System.out.println("C:\\temp\\Exercício\\slb.csv");
        String sourceFiles = "C:\\temp\\Exercício\\slb.csv";

        // instância novo ficheiro com o string passado
        File sourcefile = new File(sourceFiles);

        // encontra o caminho para pasta pai
        String sourceFolders = sourcefile.getParent();
        // cria a nova pasta
        boolean successDir = new File(sourceFolders + "\\slb").mkdir();
        System.out.println("New directory create: " + successDir);
        // cria ficheiro de destino
        String targetFileStr = sourceFolders + "\\slb\\slb.csv";

        // Bloco try
        try (BufferedReader br = new BufferedReader(new FileReader(sourcefile))) {

            String itemCsv = br.readLine();

            while (itemCsv != null) {
                // lendo o arquivo
                String[] fields = itemCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                // adicionando na lista
                list.add(new Product17(name, price, quantity));

                // lendo nova linha
                itemCsv = br.readLine();
            }
            // saindo do while,
            // novo bloco try, para escrever novo arquivo

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

                // percorrendo a lista e escrevendo no ficheiro de destino
                for (Product17 item : list) {
                    bw.write(item.getName() + ", " + String.format("$ %.2f ", item.totalValue()));
                    bw.newLine();
                }
                System.out.println("New File Created/Update!");
            }

            // bloco catch para capturar erros de escrita no novo arquivo
            catch (IOException e) {
                System.out.println("Error writing file " + e.getMessage());
            }
        }
        // bloco catch para erros de leitura no ficheiro de origem
        catch (IOException e) {
            System.out.println("Error reading file " + e.getMessage());
        }

        sc.close();
    }
}