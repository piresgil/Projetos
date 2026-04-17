package application;/*
 *  @ Daniel Gil
 */

import java.io.*;
import java.util.Scanner;

public class ClassFile {
    /*
    *  
    */
    public static void main(String[] args) throws Exception {

        File file = new File("c://temp//in.txt");
        Scanner sc = null;

        try {
            sc = new Scanner(file);// o scanner vai ler o ficheiro

            // condição para ver se ainda existe outra linha no ficheiro
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
        // bloco Catch
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
        // Bloco Finally, apenas para fechar o scanner
        // tem que ser testado caso de erro na leitura
        // do ficheiro ou outro erro com o scanner.
        finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}

class FileReaderBufferedReader {
    /*
     *
     */
    public static void main(String[] args) throws Exception {

        String path = "c://temp//in.txt";
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(path);// pega o caminho do ficheiro, passado pela String
            br = new BufferedReader(fr);// instância a partir do FileReader()
            // também pode ser assim, usando apenas a var br para as 2 Instâncias
            // br = new BufferedReader(new FileReader(path));

            String line = br.readLine();
            // condição para ver se existem outras linhas e ir mostrando
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        }
        // bolo Catch
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
        // Bloco Finally
        // com bloco try'catch, para tratar algum erro
        // que possa surgir ao fechar os readers (fileReader e BufferedReader)
        finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }

            }
            // bloco catch
            catch (IOException e) {
                e.printStackTrace();// caso haja algum erro, ja vem com trajeto do erro
            }
        }

        System.out.println("---Final---");
    }
}

class FileWriterBufferedWriter {
    /*
     *
     */
    public static void main(String[] args) throws Exception {
        System.out.println("---Inicio---");

        String[] lines = new String[] { "SLB", "Benfica", "1904" };

        String path = "c:\\temp\\out.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("---File create---");
        }
        // bloco catch para erros de escrita (IO)
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("---Final---");
    }
}

class FilePath {
    /*
     *
     */
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a file path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        System.out.println("getName : " + path.getName());
        System.out.println("getParent : " + path.getParent());
        System.out.println("getPath : " + path.getPath());

        sc.close();
        System.out.println("---Final---");
    }
}