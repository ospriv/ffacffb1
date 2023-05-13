package com.ospriv.greencode.dto;

import java.util.Objects;

/**
 * Clan
 */

public class Clan {

  private int numberOfPlayers;

  private int points;

  /**
   * Get numberOfPlayers
   * minimum: 1
   * maximum: 1000
   * @return numberOfPlayers
  */
  public int getNumberOfPlayers() {
    return numberOfPlayers;
  }

  public void setNumberOfPlayers(int numberOfPlayers) {
    this.numberOfPlayers = numberOfPlayers;
  }

  /**
   * Get points
   * minimum: 1
   * maximum: 1000000
   * @return points
  */
  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Clan clan = (Clan) o;
    return Objects.equals(this.numberOfPlayers, clan.numberOfPlayers) &&
        Objects.equals(this.points, clan.points);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfPlayers, points);
  }

}

