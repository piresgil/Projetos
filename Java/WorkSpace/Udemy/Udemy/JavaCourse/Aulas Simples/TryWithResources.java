package application;/*
 *  @ Daniel Gil
 */

import java.io.File;
import java.util.Scanner;

public class TryWithResources {
    /*
    *  
    */
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        // vector de File com função para mostrar diretórios(pastas)
        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("FOLDERS:");
        // FOR para ler o vector que vai mostrar as pastas existentes
        // no caminho capturado no scanner
        for (File folder : folders) {
            System.out.println(folder);
        }
        // Vector de File que vai mostrar os ficheiros
        File[] files = path.listFiles(File::isFile);
        System.out.println("FILES:");
        // FOR para ler o vector que vai mostrar os files (ficheiros) existentes
        // na na pasta passada no scanner
        for (File file : files) {
            System.out.println(file);
        }
        // criando uma sub pasta no caminho passado no scanner
        //
        boolean success = new File(strPath + "//subdir").mkdir();
        System.out.println("Directory create successful " + success);

        sc.close();
        System.out.println("---Final---");
    }
}