package com.ospriv.greencode.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Account
 */

public class Account {

  private String account;

  private int debitCount = 0;

  private int creditCount = 0;

  private BigDecimal balance = BigDecimal.ZERO;

  public Account(String account) {
    this.account = account;
  }


  /**
   * Get account
   * @return account
  */
  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  /**
   * Number of debit transactions
   * @return debitCount
  */

  public Integer getDebitCount() {
    return debitCount;
  }

  public void setDebitCount(Integer debitCount) {
    this.debitCount = debitCount;
  }

  /**
   * Number of credit transactions
   * @return creditCount
  */

  public Integer getCreditCount() {
    return creditCount;
  }

  public void setCreditCount(Integer creditCount) {
    this.creditCount = creditCount;
  }

  /**
   * Get balance
   * @return balance
  */

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(this.account, account.account);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account);
  }

  public void decrease(BigDecimal amount) {
    this.balance = this.balance.subtract(amount);
    debitCount++;
  }

  public void increase(BigDecimal amount) {
    this.balance = this.balance.add(amount);
    creditCount++;
  }
}

