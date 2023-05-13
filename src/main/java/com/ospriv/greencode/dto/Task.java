package com.ospriv.greencode.dto;

import java.util.Objects;

/**
 * Task
 */

public class Task {

  private Integer region;

  /**
   * Type of request
   */
  public enum RequestTypeEnum {
    FAILURE_RESTART, PRIORITY, SIGNAL_LOW, STANDARD
  }

  private RequestTypeEnum requestType;

  private Integer atmId;

  public Integer getRegion() {
    return region;
  }

  public void setRegion(Integer region) {
    this.region = region;
  }

  /**
   * Type of request
   * @return requestType
  */
  
  public RequestTypeEnum getRequestType() {
    return requestType;
  }

  public void setRequestType(RequestTypeEnum requestType) {
    this.requestType = requestType;
  }

  public Integer getAtmId() {
    return atmId;
  }

  public void setAtmId(Integer atmId) {
    this.atmId = atmId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return Objects.equals(this.region, task.region) &&
        Objects.equals(this.requestType, task.requestType) &&
        Objects.equals(this.atmId, task.atmId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(region, requestType, atmId);
  }

}

