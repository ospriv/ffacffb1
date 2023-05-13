package com.ospriv.greencode.dto;

import java.util.Objects;

/**
 * ATMs details
 */

public class ATM {

  private final Integer region;

  private final Integer atmId;

  public ATM(Integer region, Integer atmId) {
    this.region = region;
    this.atmId = atmId;
  }


  /**
   * Get region
   * minimum: 1
   * maximum: 9999
   * @return region
  */
  public Integer getRegion() {
    return region;
  }



  /**
   * Get atmId
   * minimum: 1
   * maximum: 9999
   * @return atmId
  */
  public Integer getAtmId() {
    return atmId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ATM ATM = (ATM) o;
    return Objects.equals(this.region, ATM.region) &&
        Objects.equals(this.atmId, ATM.atmId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(region, atmId);
  }


}

