/*
 *  @ Daniel Gil
 */

package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

  private Integer roomNumber;
  private Date checkIn;
  private Date checkOut;

  public Reservation(Integer roomNumber, Date checkIn, Date checOut) {
    this.roomNumber = roomNumber;
    this.checkIn = checkIn;
    checkOut = checOut;
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

  public Date getChecOut() {
    return checkOut;
  }

  // data em milisegungos
  // method duration
  public long duration() {
    long diff = checkOut.getTime() - checkIn.getTime();
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
  }

  public void updateDates(Date checkIn, Date checkOut) {
    this.checkIn = checkIn;
    this.checkOut = checkOut;
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
        + " nigths";
  }
}
