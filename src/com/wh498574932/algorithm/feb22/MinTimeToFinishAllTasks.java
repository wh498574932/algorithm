package com.wh498574932.algorithm.feb22;

import java.util.List;

/**
 * Given a list of Tasks requires certain time to finish and all the prerequisite tasks. Tasks can be executed
 * parallel on unlimited resources. Find the minumum time required for finishing all tasks.
 */
public class MinTimeToFinishAllTasks {

    public int minTimeToFinishAllTasks(List<Task> tasks) {
        int ret = 0;
        for(Task t : tasks) {
            ret = Math.max(ret, helper(t));
        }
        return ret;
    }

    private int helper(Task t) {
        if(t.max > 0) {
            return t.max;
        }
        int max = 0;
        for(Task p : t.pre) {
            max = Math.max(max, helper(p));
        }
        t.max = max + t.time;
        return max + t.time;
    }

    static class Task {
        int time;
        List<Task> pre;
        int max;

        Task(int time, List<Task> pre) {
            this.time = time;
            this.pre = pre;
        }
    }
}
