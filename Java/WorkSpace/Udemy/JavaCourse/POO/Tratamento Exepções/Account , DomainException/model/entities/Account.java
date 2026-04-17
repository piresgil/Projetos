/*
 *  @ Daniel Gil
 */

 package model.entities;

import model.exceptions.DomainException;

public class Account {

  private Integer number;
  private String holder;
  private Double balance;
  private Double withdrawLimit;

  public Account(Integer number, String holder, Double balance, Double withdrawLimit) {

    this.number = number;
    this.holder = holder;
    this.balance = balance;
    this.withdrawLimit = withdrawLimit;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getHolder() {
    return holder;
  }

  public void setHolder(String holder) {
    this.holder = holder;
  }

  public void setWithdrawLimit(Double withdrawLimit) {
    this.withdrawLimit = withdrawLimit;
  }

  public Double getWithdrawLimit() {
    return withdrawLimit;
  }

  public Double getBalance() {
    return balance;
  }

  public void withdraw(double amount) {
    balance -= amount;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public void update(double withdrawLimit, double amount) throws DomainException {

    if (withdrawLimit < amount) {
      throw new DomainException("The amount exceeds withdraw limit");
    }

    if (balance < amount) {
      throw new DomainException("Not enough balance");
    }
  }
}