    //criada class possitiveNegative
public class PositiveNegative {
    // "psvm" abreviatura do metodo main (String[] args)
    public static void main(String[] args) {
        //chmando metodo checkNumber
        checkNumber(0);
    }

    // para chekar number
    public static void checkNumber (int number){

        if(number > 0){
            System.out.println("Positive");
        }else if (number < 0){
            System.out.println("Negative");
        }else if (number == 0){
            System.out.println("Neutro");
        }

    }
}
