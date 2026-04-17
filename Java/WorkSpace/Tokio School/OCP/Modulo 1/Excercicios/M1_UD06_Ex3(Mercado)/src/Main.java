/**
 * @author Daniel Gil
 */
import model.Mercado;
import model.clientes.Cliente;
import model.enuns.Turno;
import model.funcionarios.Funcionario;
import model.funcionarios.SubContratado;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");

        Cliente cl1 =
                new Cliente("Daniel", "Gil", 10000, "rua1", 966666661,
                        1, 99);
        Cliente cl2 =
                new Cliente("Francisca", "Maria", 10002, "rua2", 966666662,
                        2, 1);
        Cliente cl3 =
                new Cliente("Maria", "Elisa", 10003, "rua3", 966666663,
                        3, 2);


        Funcionario fun1 =
                new Funcionario("Joaquim", "Gil", 10004, "rua4", 966666664,
                        1004, 1000, Turno.MANHA);
        Funcionario fun2 =
                new Funcionario("Maria", "Pires", 10005, "rua5", 966666665,
                        1005, 1000, Turno.TARDE);
        Funcionario fun3 =
                new Funcionario("João", "Gil", 10006, "rua6", 966666666,
                        1006, 1000, Turno.NOITE);
        Funcionario sub1 =
                new SubContratado("Laurinda", "Gil", 10007, "rua7", 966666667,
                        1007, 1000, Turno.MANHA, "Caixa");
        Funcionario sub2 =
                new SubContratado("Francisco", "Catarro", 10008, "rua8", 966666668,
                        1008, 1000, Turno.TARDE, "Fruta");
        Funcionario sub3 =
                new SubContratado("Carlos", "Gil", 10009, "rua9", 966666669,
                        1009, 1000, Turno.NOITE, "Talho");

        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);
        double valorCompra = 100;
        System.out.println(cl1.getNome() + ", valor Compra: " + valorCompra + ", valor Final: " + cl1.compra(valorCompra));
        System.out.println(cl2.getNome() + ", valor Compra: " + valorCompra + ", valor Final: " + cl2.compra(valorCompra));
        System.out.println(cl3.getNome() + ", valor Compra: " + valorCompra + ", valor Final: " + cl2.compra(valorCompra));
        //
        System.out.println();
        Mercado mercado = new Mercado(fun1);
        Mercado.listaFuncionarios.add(fun2);
        Mercado.listaFuncionarios.add(fun3);
        //
        Mercado.listaFuncionarios.add(sub1);
        Mercado.listaFuncionarios.add(sub2);
        Mercado.listaFuncionarios.add(sub3);
        mercado.funcionariosMercado();

    }
}