package com.ospriv.greencode.dto;

import java.util.List;
import java.util.Objects;

/**
 * Players
 */

public class Players {

  private int groupCount;

  private List<Clan> clans = null;

  /**
   * Number of players in single group
   * minimum: 1
   * maximum: 1000
   * @return groupCount
  */
  public int getGroupCount() {
    return groupCount;
  }

  public void setGroupCount(int groupCount) {
    this.groupCount = groupCount;
  }

  /**
   * Get clans, max = 20000
   * @return clans
  */
  public List<Clan> getClans() {
    return clans;
  }

  public void setClans(List<Clan> clans) {
    this.clans = clans;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Players players = (Players) o;
    return Objects.equals(this.groupCount, players.groupCount) &&
        Objects.equals(this.clans, players.clans);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupCount, clans);
  }

}

