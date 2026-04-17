/**
 * @author Daniel Gil
 */

import model.ArrayCharSequenceTokio;
import model.BackwardsStringSequenceTokio;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");

        ArrayCharSequenceTokio arr = new ArrayCharSequenceTokio(new char[]{'1', '2', '3', '4', '5'});
        System.out.println(arr);
        System.out.println(arr.subSequence(0, 4));
        System.out.println(arr.subSequence(1, 4));
        System.out.println(arr.subSequence(2, 3));
        System.out.println(arr.subSequence(0, 2));
        System.out.println();
        BackwardsStringSequenceTokio bss = new BackwardsStringSequenceTokio("abcde");
        System.out.println(bss);
        System.out.println(bss.subSequence(0, 4));
        System.out.println(bss.subSequence(1, 4));
        System.out.println(bss.subSequence(2, 3));
        System.out.println(bss.subSequence(0, 2));

    }
}