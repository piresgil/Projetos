/*
* @ Daniel Gil
*/
package exerciciosFixacaoListas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exerciciosFixacaoListas.entities.Employee;

public class ExerciciosFixacaoListas {
    /*
     * Fazer um programa para ler um número inteiro N e depois os dados (id, nome e
     * salario) de
     * N funcionários. Não deve haver repetição de id.
     * Em seguida, efetuar o aumento de X por cento no salário de um determinado
     * funcionário.
     * Para isso, o programa deve ler um id e o valor X. Se o id informado não
     * existir, mostrar uma
     * mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos
     * funcionários,
     * conforme exemplos.
     * Lembre-se de aplicar a técnica de encapsulamento para não permitir que o
     * salário possa
     * ser mudado livremente. Um salário só pode ser aumentado com base em uma
     * operação de
     * aumento por porcentagem dada.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        System.out.print("---How many employees will be registered? ");
        int n = sc.nextInt();
        sc.nextLine();// QUEIMA LINHA

        // Instanciando lista
        List<Employee> list = new ArrayList<>();

        // PART 1 - READING DATA:
        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Employee NR" + (i + 1));

            System.out.print("ID: ");
            Integer id = sc.nextInt();
            sc.nextLine();// QUEIMA LINHA

            // Condiçao de id iguais, 
            //(METODO NO FINAL DA CLASS PRINCIPAL) (ESTA CLASS)
            while (hasId(list, id)) {
                System.out.println();
                System.out.println("Id alredy taken. Try again:");
                System.out.print("Id: ");
                id = sc.nextInt();
                sc.nextLine();// quima liha
            }

            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            list.add(new Employee(id, name, salary));
        }

        /* PART 2 - UPDATING SALARY OF GIVEN EMPLOYEE: */
        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        sc.nextLine();// queima linha
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if (emp != null) {
            System.out.print("Enter the percentage: ");
            Double percentage = sc.nextDouble();
            emp.IncreaseSalary(percentage);
        } else {
            System.out.println("This id does not exist!");
        }

        // PART 3 - LISTING EMPLOYEES:
        System.out.println();
        System.out.println("List of Employees:");
        for (Employee obj : list) {
            System.out.println(obj);
        }

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }

    // metodo para condicionar a repetiçao de ID´s
    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
