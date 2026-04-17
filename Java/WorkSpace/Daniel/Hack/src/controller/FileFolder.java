package controller; /**
 * @author Daniel
 * @version 1.0
 */

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static controller.SystemInfo.*;

public class FileFolder {
    /**
     * Path
     * <p>
     * Variaveis para path aplicação
     * Public para serem acessíveis noutra class ("controller.Processo")
     */
    static final String pathFicheiroFinal = "//Ficheiro.txt";
    static final String pathDiretorioFinal = "c:\\Temp\\dir\\in\\out";

    static String infoSystem;

    /**
     * Cria uma instância da Class "Robot",
     * Responsável pelos eventos, como teclado e rato
     */
    private static Robot robot;

    /**
     * Method Criar Diretório
     * <p>
     * Usando o "Files", para criar folders/diretórios,
     * Utiliza o seu method "createDirectories"
     * para criar os diretórios (em falta, se os houver)
     */
    public static void criarDiretorios() {
        System.out.println("A criar diretórios");
        try {
            Files.createDirectories(Paths.get(pathDiretorioFinal));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Diretórios criados com sucesso: " + pathDiretorioFinal);
    }

    /**
     * Method Apagar Diretório
     * <p>
     * Usando "File" & "Paths" e os seus methods,
     * recebe um path numa "String", para iniciar o "Paths", e vai excluir com o "Files"
     * e com o method "walkFileTree",
     * que permite percorrer uma árvore de ficheiros e aplicar operações em cada ficheiro ou diretório encontrado.
     * Este método é útil para operações recursivas, como a exclusão de diretórios com subdiretórios e ficheiros.
     * <p>
     *
     * @Override FileVisitResult, é uma Enumeração {CONTINUE, TERMINATE, SKIP_SUBTREE, SKIP_SIBLINGS}.
     * Utiliza method "postVisitDirectory", Ele é chamado após a visita de todos os ficheiros dentro de um diretório específico.
     * Esse método é útil para realizar operações que devem ser feitas apenas depois que todos os ficheiros
     * de um diretório foram processados, como apagar o diretório em si ou realizar algum tipo de limpeza ou resumo.
     * "BasicFileAttributes", é uma “Interface” que fornece um conjunto de métodos para obter informações básicas
     * sobre ficheiros e diretórios, como a data de criação, o tamanho, e as permissões de leitura/escrita.
     * Estes atributos são úteis para verificar detalhes de ficheiros e decidir sobre operações como apagar,
     * mover ou copiar.
     */
    public static void apagarDiretorio() {
        try {
            Path diretorio = Paths.get(pathDiretorioFinal.substring(0, 11));

            // Verifica se o diretório existe
            if (Files.exists(diretorio) && Files.isDirectory(diretorio)) {
                // Caminha pelo diretório e apaga cada ficheiro/subdiretório
                Files.walkFileTree(diretorio, new SimpleFileVisitor<>() {


                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        Files.delete(dir); // Apaga o diretório depois de apagar os seus conteúdos
                        return FileVisitResult.CONTINUE;
                    }
                });

                System.out.println("Diretório apagado com sucesso: " + diretorio.getParent());
            } else {
                System.out.println("O diretório especificado não existe ou não é um diretório: " + diretorio);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method Criar Ficheiro, (Qualquer)
     * <p>
     * Usando "Files" e os seus methods, através do do path do ficheiro,
     */
    public static void criarFicheiro() {
        //pathFicheiro = new File("//in.txt");
        // Define o caminho do ficheiro a ser criado
        Path path = Paths.get(pathDiretorioFinal + pathFicheiroFinal);

        // Method que imprime na consla os dados do sytem
        SystemInfo.infoDataConsole();
        // vector para armazenar dados do system
        String[] lines = new String[]{SystemInfo.osName, SystemInfo.osVersion, SystemInfo.osArch,
                env.entrySet().toString(), Runtime.getRuntime().toString()};
        //String path = "c:\\temp\\out.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.toString()))) {
            bw.newLine();
            bw.newLine();
            for (String line : lines) {
                bw.write(line + "\n");
                bw.newLine();
            }

            System.out.println("---File create---");
        }
        // bloco catch para erros de escrita (IO)
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Cria o ficheiro, se ele não existir
            Files.createFile(path);
            System.out.println("Ficheiro criado com sucesso: " + path.getFileName());

        } catch (FileAlreadyExistsException e) {
            System.out.println("O ficheiro já existe: " + path);
        } catch (IOException e) {
            System.err.println("Erro ao criar o ficheiro: " + e.getMessage());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method Apagar Ficheiro,
     * <p>
     *
     * @Override FileVisitResult, é uma Enumeração {CONTINUE, TERMINATE, SKIP_SUBTREE, SKIP_SIBLINGS}.
     * Utiliza methods "visitFile", utilizado para apagar cada ficheiro encontrado num diretório especificado,
     * o method "BasicFileAttributes", é uma “Interface” que fornece um conjunto de métodos para obter informações básicas
     * sobre ficheiros e diretórios, como a data de criação, o tamanho, e as permissões de leitura/escrita.
     * Estes atributos são úteis para verificar detalhes de ficheiros e decidir sobre operações como apagar,
     * mover ou copiar.
     */
    public static void apagarFicheiro() {
        try {
            Path path = Paths.get(pathDiretorioFinal + pathFicheiroFinal);

            // Verifica se o diretório existe
            if (Files.exists(path)) {
                // Caminha pelo diretório e apaga cada ficheiro/subdiretório
                Files.walkFileTree(path, new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file); // Apaga cada ficheiro
                        return FileVisitResult.CONTINUE;
                    }
                });
                System.out.println("Ficheiro apagado com sucesso: " + path.getFileName());
            } else {
                System.out.println("O diretório especificado não existe ou não é um diretório: " + path);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
