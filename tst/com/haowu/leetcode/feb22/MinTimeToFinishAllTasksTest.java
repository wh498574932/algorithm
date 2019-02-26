package com.haowu.leetcode.feb22;

import static com.haowu.leetcode.feb22.MinTimeToFinishAllTasks.Task;
import static com.haowu.leetcode.utilities.ArrayList.createArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MinTimeToFinishAllTasksTest {
    @Test
    public void test() {
        Task task1 = new Task(1, new ArrayList<>());
        Task task2 = new Task(2, new ArrayList<>());
        Task task3 = new Task(3, createArrayList(new Task[]{task1, task2}));
        Task task4 = new Task(4, createArrayList(new Task[]{task3}));
        Task task5 = new Task(5, createArrayList(new Task[]{task3}));
        Task task6 = new Task(6, createArrayList(new Task[]{task4, task5}));
        assertEquals(
            16,
            new MinTimeToFinishAllTasks().minTimeToFinishAllTasks(
                createArrayList(
                    new Task[] {
                        task1, task2, task3, task4, task5, task6
                    }
                )
            )
        );
    }
}
