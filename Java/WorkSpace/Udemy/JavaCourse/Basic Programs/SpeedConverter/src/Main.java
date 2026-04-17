public class Main {
    public static void main(String[] args) {
        //chama medoto speedconverter da class speed converter
        long miles = SpeedConverter.toMilesPerHour(10.5);
        //criada variavel mile para fazer o print da conversao
        System.out.println("Miles = " + miles);

        SpeedConverter.printConversion(10.5);
    }
}
