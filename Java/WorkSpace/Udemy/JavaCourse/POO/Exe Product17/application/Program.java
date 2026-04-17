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

public class Program {
    /*
    *  
    */
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        List<Product17> list = new ArrayList<>();

        System.out.print("Enter a path: ");
        String sourceFileStr = "c://temp//Exercício//in.csv"; // sc.nextLine();

        // Criando pasta para salvar novo ficheiro
        // encontra a pasta pai
        File sourceFile = new File(sourceFileStr);
        String sourceFolderStr = sourceFile.getParent();

        // cria a pasta
        // depois acha o caminho pai
        boolean successDir = new File(sourceFolderStr + "\\out").mkdir();
        System.out.println("Directory create: " + successDir);
        // cria o ficheiro onde vai ser gravado os novos dados
        String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

            // le as linhas do ficheiro pai
            String itemCsv = br.readLine();
            while (itemCsv != null) {

                String[] fields = itemCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                // instância um produto na lista
                list.add(new Product17(name, price, quantity));

                // le uma nova linha
                itemCsv = br.readLine();
            }

            // novo bloco TRY para criar novo ficheiro
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

                // percorre a lista
                for (Product17 item : list) {

                    // escreve no novo ficheiro criado,
                    // com o method que faz o total dos produtos
                    bw.write(item.getName() + "," + String.format("%.2f $ ", item.totalValue()));
                    // passa a uma nova linha
                    bw.newLine();
                }

                // ficheiro criado
                System.out.println(targetFileStr + " CREATED!");

            }
            // Bloco catch para erros de escrita
            catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }

        }
        // Bloco catch para erros de leitura
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}