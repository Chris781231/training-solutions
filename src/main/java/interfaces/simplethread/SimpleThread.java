package interfaces.simplethread;

import java.util.List;

public class SimpleThread implements Runnable {

    private final List<String> tasks;

    public SimpleThread(List<String> tasks) {
        if (tasks == null) {
            throw new IllegalArgumentException("The tasks must not be null!");
        }
        this.tasks = tasks;
    }

    private boolean nextStep() {
        String nextStep = tasks.get(tasks.size() - 1);
        tasks.remove(nextStep);
        return !tasks.isEmpty();
    }

    @Override
    public void run() {
        if (!tasks.isEmpty()) {
            while (nextStep()) {
                nextStep();
            }
        }
    }

    public List<String> getTasks() {
        return tasks;
    }
}
