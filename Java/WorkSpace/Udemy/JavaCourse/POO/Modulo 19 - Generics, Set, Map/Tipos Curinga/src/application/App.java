/*
*  @ Daniel Gil
*/

package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    /*
     * 
     */
    public static void main(String[] args) throws Exception {

        // problemas de casting

        /*
         * List<Object> myObjs = new ArrayList<Object>();
         * List<Integer> myNumbers = new ArrayList<Integer>();
         * myObjs = myNumbers; // erro de compilação
         */
        List<?> myObjs = new ArrayList<Object>();
        List<Integer> myNumbers = new ArrayList<Integer>();
        myObjs = myNumbers;

        // exemplo 2
        /*
         * tipos curinga nao pode adiccionar na lista, apenas acessa a lista
         */
        List<Integer> myInts = Arrays.asList(5, 2, 10);

        printList(myInts);
    }

    // method com tipo curinga (?)
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}