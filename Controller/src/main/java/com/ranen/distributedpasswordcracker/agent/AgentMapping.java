package com.ranen.distributedpasswordcracker.agent;

import com.ranen.distributedpasswordcracker.tasks.Task;
import com.ranen.distributedpasswordcracker.tasks.TaskTracker;

import java.util.concurrent.ConcurrentHashMap;

public class AgentMapping {

    private static final ConcurrentHashMap<String, Task> agentMap = new ConcurrentHashMap<>();

    private static TaskTracker workloadTracker = null;

    public void setNextWorkItem(String newPassword) {
        workloadTracker = new TaskTracker(newPassword);
    }

    public Task assignWorkToNode(String nodeIp) {
        Task nextTaskItem = workloadTracker.getNextTask();
        agentMap.put(nodeIp, nextTaskItem);
        return nextTaskItem;
    }

    public boolean updateWorkItemStatus(String nodeIp, String targetPassword, String lastAttemptedCombination) {
        return agentMap.get(nodeIp).updateTaskProgress(targetPassword, lastAttemptedCombination);
    }
}
