package com.ranen.distributedpasswordcracker.tasktests;

import com.ranen.distributedpasswordcracker.tasks.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TaskTests {

    @Test
    void testWorkBaseCase() {
        String targetPassword = "targetPwd";
        String lastAttemptedCombination = "lastattempt";
        Task task = new Task(lastAttemptedCombination.length(), targetPassword, lastAttemptedCombination);
        assertThat(task.toString()).contains("asdf");
        //convert to Json to compare
    }
}
