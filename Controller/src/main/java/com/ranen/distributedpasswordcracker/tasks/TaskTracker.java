package com.ranen.distributedpasswordcracker.tasks;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskTracker {

    //Password
    private final String targetPassword;

    //Password length
    private AtomicInteger passwordLength = new AtomicInteger(1);

    //queue for incomplete work
    private ConcurrentLinkedQueue<Task> incompleteTaskTracker = new ConcurrentLinkedQueue<>();

    public TaskTracker(String targetPassword) {
        this.targetPassword = targetPassword;
    }

    public Task getNextTask() {
        if (!incompleteTaskTracker.isEmpty()) {
            return incompleteTaskTracker.poll();
        }
        Task nextTask = new Task(passwordLength.getAndAdd(1), targetPassword, "");
        return nextTask;
    }

    public void registerUnfinishedWork(Task unfinishedTask) {
        incompleteTaskTracker.add(unfinishedTask);
    }
}