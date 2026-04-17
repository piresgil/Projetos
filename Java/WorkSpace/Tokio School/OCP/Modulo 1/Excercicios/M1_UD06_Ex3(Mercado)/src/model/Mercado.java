package model;

import model.funcionarios.Funcionario;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Mercado
 */
public class Mercado {
    /**
     * Lista de Funcionarios
     */
    public static List<Funcionario> listaFuncionarios = new ArrayList<>();

    /**
     * Constructor,
     * adiciona um funcionario ha lista
     */
    public Mercado(Funcionario funcionario) {
        this.listaFuncionarios.add(funcionario);
    }

    /**
     * Method Funcionarios do Mercado,
     * imprime a lista de funcionarios
     */
    public void funcionariosMercado() {
        for (Funcionario funcionario : listaFuncionarios) {
            System.out.println(funcionario);
        }
    }
}
