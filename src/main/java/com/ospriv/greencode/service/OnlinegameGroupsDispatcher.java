package com.ospriv.greencode.service;

import com.ospriv.greencode.dto.Clan;
import com.ospriv.greencode.dto.Players;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OnlinegameGroupsDispatcher {
    private static final Comparator<Clan> clanComparator = (left, right) -> {
        if (left.getPoints() == right.getPoints()) {
            return left.getNumberOfPlayers() - right.getNumberOfPlayers();
        } else {
            return right.getPoints() - left.getPoints();
        }
    };
    private final int groupCount;
    private final int offset;
    private final List<Clan> clans;
    private final int[] freeSpace;

    public OnlinegameGroupsDispatcher(Players players) {
        this.groupCount = players.getGroupCount();
        this.clans = players.getClans();
        this.clans.sort(clanComparator);

        final int groupsCountMax = players.getClans().size();
        this.offset = halfTreeSize(groupsCountMax);
        this.freeSpace = new int[2 * offset];
    }

    public List<List<Clan>> dispatch() {
        final List<List<Clan>> resultClansGrouping = new ArrayList<>(clans.size());
        int newIndex;
        for (Clan clan : clans) {
            int reqSpace = clan.getNumberOfPlayers();
            if (reqSpace > freeSpace[1]) {
                newIndex = resultClansGrouping.size();
                List<Clan> newGroup = new ArrayList<>();
                newGroup.add(clan);
                resultClansGrouping.add(newGroup);
                updateFreeSpace(newIndex, groupCount - reqSpace);
            } else {
                newIndex = findGropIndex(reqSpace);
                resultClansGrouping.get(newIndex).add(clan);
                updateFreeSpace(newIndex, freeSpace[newIndex + offset] - reqSpace);
            }
        }

        return resultClansGrouping;
    }

    private int findGropIndex(int reqSpace) {
        int pos = 1;
        while (pos < offset) {
            pos *= 2;
            if (freeSpace[pos] < reqSpace) {
                pos++;
            }
        }
        return pos - offset;
    }

    private void updateFreeSpace(int index, int newValue) {
        int pos = index + offset;
        freeSpace[pos] = newValue;
        pos /= 2;
        while (pos > 0) {
            freeSpace[pos] = Math.max(freeSpace[2 * pos], freeSpace[2 * pos + 1]);
            pos /= 2;
        }
    }

    private int halfTreeSize(int groupsCountMax) {
        int result = 1;
        while (result < groupsCountMax) {
            result *= 2;
        }
        return result;
    }
}
