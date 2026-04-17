/**
 * @author Daniel Gil
 */

package model.stack;

public interface Stack<T> {

    /**
     * Method Push
     *
     */
    void push(T elemento);

    /**
     * Method Pop
     *
     * @return caratere a ser eliminado
     */
    T pop();
}
