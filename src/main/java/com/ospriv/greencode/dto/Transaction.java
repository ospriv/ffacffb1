package com.ospriv.greencode.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Transaction
 */

public class Transaction {

  private String debitAccount;

  private String creditAccount;

  private BigDecimal amount;

  /**
   * Get debitAccount
   * @return debitAccount
  */
  public String getDebitAccount() {
    return debitAccount;
  }

  public void setDebitAccount(String debitAccount) {
    this.debitAccount = debitAccount;
  }


  /**
   * Get creditAccount
   * @return creditAccount
  */
  public String getCreditAccount() {
    return creditAccount;
  }

  public void setCreditAccount(String creditAccount) {
    this.creditAccount = creditAccount;
  }

  /**
   * Get amount
   * @return amount
  */
  
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.debitAccount, transaction.debitAccount) &&
        Objects.equals(this.creditAccount, transaction.creditAccount) &&
        Objects.equals(this.amount, transaction.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(debitAccount, creditAccount, amount);
  }

}

