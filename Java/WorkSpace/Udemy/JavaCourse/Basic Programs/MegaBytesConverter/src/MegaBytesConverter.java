// cria class
public class MegaBytesConverter {
    //cria metodo main args
    public static void main(String[] args) {
        printMegaBytesAndKiloBytes(2000);
    }
    //cria metodo print mega bytes and kilobytes
    public static void printMegaBytesAndKiloBytes(int kiloBytes) {

        if(kiloBytes < 0) {
            System.out.println(" Invalid Value ");
        }else {
            int megaBytes = kiloBytes / 1024 ;//formula de conversão
            int remainingKiloBytes = kiloBytes % 1024 ;//resto da divisao da formula
            //cria varial para mostrar print em um so String
            String result = kiloBytes + " KB " + "= " + megaBytes + " MB " + "and " + remainingKiloBytes + " KB";
            System.out.println(result);
        }
    }
}
