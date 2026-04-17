/*
 * @ Daniel Gil
 */

package exercicioFixacao.src.entities;

public class CurrencyConverter {
    /*
    *
    */
    public static double real;
    public static double quantity;
    public static double iof = 0.06; // 6%

    public static double Converter(double real, double quantity) {
        return real * quantity * (1.0 + iof); //
    }
}