package collections.queue;

import collections.naftalin.CodingTask;
import collections.naftalin.PhoneTask;
import collections.naftalin.Task;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueUsing {

    public static void main(String[] args) {

        PhoneTask mikePhone = new PhoneTask("Mike", "987 6543");
        PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");
        CodingTask databaseCode = new CodingTask("db");
        CodingTask interfaceCode = new CodingTask("gui");
        CodingTask logicCode = new CodingTask("logic");

        Queue<Task> taskQueue = new ArrayDeque<Task>();
        taskQueue.offer(mikePhone);
        taskQueue.offer(paulPhone);

        Task nextTask = taskQueue.poll();
        if (nextTask != null) {
            // process nextTask
        }

//        The choice between using poll and remove depends on whether we want to regard queue emptiness as an exceptional condition. Realisticallygiven the nature of the applicationthat might be a sensible assumption, so this is an alternative:

        try {
            Task nextTask2 = taskQueue.remove();
            // process nextTask
        } catch (NoSuchElementException e) {
            // but we *never* run out of tasks!
        }



    }
}
