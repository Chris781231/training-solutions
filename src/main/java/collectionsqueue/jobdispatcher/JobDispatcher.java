package collectionsqueue.jobdispatcher;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {

    public Queue<Job> addJob(Job... jobs) {
        if (jobs == null || jobs.length == 0) {
            throw new IllegalArgumentException("empty parameter");
        }

        return new PriorityQueue<>(Arrays.asList(jobs));
    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        if (jobs == null || jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }

        return jobs.poll();
    }
}
