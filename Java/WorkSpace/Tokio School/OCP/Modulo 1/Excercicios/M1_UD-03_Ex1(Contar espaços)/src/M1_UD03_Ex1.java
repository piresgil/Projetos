import java.util.Scanner;

public class M1_UD03_Ex1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("*** Bem Vindo ***");

        System.out.println("Digite uma frase:");
        String texto = sc.nextLine();
        int contadorEspacos = 0;

        for (int i = 0; i < texto.length();i++){
            char caractere = texto.charAt(i);

            if(caractere == '.'){
                break; // sai do loop ao primeiro ponto
            }
            if(caractere == ' '){ // condição para incremento de contador
                contadorEspacos++;
            }
        }
        //imprime
        System.out.println("Total de espaços até ao ponto: " + contadorEspacos);
            sc.close();
    }
}