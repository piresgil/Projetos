//cria class
public class SpeedConverter {
//cria Metodo MilesPerHour
    public static long toMilesPerHour(double kilometersPerHour){
        if(kilometersPerHour < 0){
            return -1;
        }
        return Math.round(kilometersPerHour / 1.609);
    }
//cria medoto Print Conversion
    public static void printConversion(double kilometersPerHour){
        if(kilometersPerHour < 0){
            System.out.println("invalid value");
        }else {
            long milesPerHour = toMilesPerHour(kilometersPerHour);
            System.out.println(kilometersPerHour + " km/h " + milesPerHour + " mi/h ");
        }
    }
}
