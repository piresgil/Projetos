/*
 *  @ Daniel Gil
 */

package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {

  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

  private Integer roomNumber;
  private Date checkIn;
  private Date checkOut;

  // Constructor
  public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
    if (!checkOut.after(checkIn)) {
      throw new DomainException("Check-out date must be after check-in date");

    }
    this.roomNumber = roomNumber;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  public Integer getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(Integer roomNumber) {

    this.roomNumber = roomNumber;
  }

  public Date getCheckIn() {
    return checkIn;
  }

  public Date getCheckOut() {
    return checkOut;
  }

  // method duration
  // data em milissegundos
  public long duration() {
    long diff = checkOut.getTime() - checkIn.getTime();
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
  }

  // method Update
  // é onde tem todas as condições
  // tratando exceções ou (propagando para o pacote Exception)
  public String updateDates(Date checkIn, Date checkOut) {

    // exceção do tipo (IllegalArgumentException)
    // é uma class que trata algumas exceções

    if (!checkOut.after(checkIn)) {
      throw new DomainException("Check-out date must be after check-in date");
    }

    Date now = new Date();
    // exceções do tipo (PraseException)
    if (checkIn.before(now) || checkOut.before(now)) {
      throw new DomainException("Reservation dates for update must be future dates");
    }

    this.checkIn = checkIn;
    this.checkOut = checkOut;
    // se retornar aqui é porque não deu quaquer erro
    return null;
  }

  @Override
  public String toString() {
    return roomNumber
        + ", checkIn: "
        + sdf.format(checkIn)
        + ", checkOut: "
        + sdf.format(checkOut)
        + ", "
        + duration()
        + " nights";
  }
}