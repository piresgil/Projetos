/*
 *  @ Daniel Gil
 */

package model.exception;

public class DomainException extends RuntimeException {
  // IllegalArgumentException
  public DomainException(String msg) {
    super(msg);
  }
}