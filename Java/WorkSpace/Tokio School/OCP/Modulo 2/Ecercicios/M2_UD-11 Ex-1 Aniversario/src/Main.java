import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate hoje = LocalDate.now();
        System.out.println("Hoje: "+ hoje.format(dtf));

        System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = sc.nextLine();

        // Formatação da data de nascimento
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, dtf);

        // Calcular Próximo Aniversário
        LocalDate proximoAniversario = dataNascimento.withYear(hoje.getYear());
        if (proximoAniversario.isBefore(hoje) || proximoAniversario.isEqual(hoje)) {
            proximoAniversario = proximoAniversario.plusYears(1);
        }

        // Calcular diferença de dias entre hoje e próximo aniversario
        long diasRestantes = ChronoUnit.DAYS.between(hoje, proximoAniversario);

        // Verifica se Aniversário já passou este ano
        if (diasRestantes < 0) {
            System.out.println("Seu aniversário já foi celebrado este ano");
        } else {
            System.out.println("Faltam " + diasRestantes + " dias para o seu Aniversário.");
        }
    }
}