package com.ranen.distributedpasswordcracker.tasks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Strings;

public class Task {
    @JsonProperty("targetPassword") private final String targetPassword;

    @JsonProperty("lastAttemptedCombination") private String lastAttemptedCombination;

    @JsonProperty("passwordLength") private final int passwordLength;

    public Task(int passwordLength, String targetPassword, String lastAttemptedCombination) {
        this.passwordLength = passwordLength;
        this.targetPassword = targetPassword;

        if (Strings.isNullOrEmpty(lastAttemptedCombination) || passwordLength != lastAttemptedCombination.length()) {
            this.lastAttemptedCombination = "";
        } else {
            this.lastAttemptedCombination = lastAttemptedCombination;
        }
    }

    public boolean updateTaskProgress(String targetPassword, String lastAttemptedCombination) {
        if (targetPassword.equals(this.targetPassword)) {
            setLastAttemptedCombination(lastAttemptedCombination);
            return true;
        }
        return false;
    }

    public void setLastAttemptedCombination(String lastAttemptedCombination) {
        this.lastAttemptedCombination = lastAttemptedCombination;
    }

    @Override
    public String toString() {
        return "Task{" +
                "targetPassword='" + targetPassword + '\'' +
                ", lastAttemptedCombination='" + lastAttemptedCombination + '\'' +
                ", passwordLength=" + passwordLength +
                '}';
    }
}
