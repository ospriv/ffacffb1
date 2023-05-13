package com.ospriv.greencode.service;

import com.ospriv.greencode.dto.ATM;
import com.ospriv.greencode.dto.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Service
public class AtmsService {

    public List<ATM> calculateOrder(List<Task> tasks) {
        final Map<Integer, List<Integer>[]> taskMap = new HashMap<>();
        List<Integer>[] areaTasks;
        for (Task task : tasks) {
            areaTasks = computeRegionData(task.getRegion(), taskMap);
            areaTasks[task.getRequestType().ordinal()].add(task.getAtmId());
        }
        return taskMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .flatMap(e -> Arrays.stream(e.getValue())
                        .flatMap(List::stream).distinct()
                        .map(atmId -> new ATM(e.getKey(), atmId))).toList();
    }

    private List<Integer>[] computeRegionData(Integer region, Map<Integer, List<Integer>[]> taskMap) {
        List<Integer>[] regionData;
        if ((regionData = taskMap.get(region)) == null) {
            regionData = (List<Integer>[]) IntStream.range(0, 4).mapToObj(ArrayList::new).toArray(ArrayList<?>[]::new);
            taskMap.put(region, regionData);
        }
        return regionData;
    }

}
