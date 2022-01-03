package com.ranen.distributedpasswordcracker.passwordmanager;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PasswordManager {

    private final ConcurrentLinkedQueue<String> workItemsToComplete = new ConcurrentLinkedQueue<>();
    private final ConcurrentHashMap<String, String> completedWorkItems = new ConcurrentHashMap<>();

    public void addWorkItem(String password) {
        workItemsToComplete.add(password);
    }

    public String getNextWorkItem() {
        return workItemsToComplete.poll();
    }

    public void completeWorkItem(String password, String solution) {
        completedWorkItems.put(password, solution);
    }

    public Map<String, String> getCompletedWorkItems() {
        return new HashMap<>(completedWorkItems);
    }
}
