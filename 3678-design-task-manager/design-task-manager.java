//arinjayjha
import java.util.*;

class Task implements Comparable<Task> {
    public int userId;
    public int taskId;
    public int priority;
    public Task(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }
    @Override
    public int compareTo(Task other) {
        if (this.priority != other.priority) return Integer.compare(other.priority, this.priority);
        if (this.taskId != other.taskId) return Integer.compare(other.taskId, this.taskId);
        return Integer.compare(other.userId, this.userId);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task t = (Task) o;
        return taskId == t.taskId && userId == t.userId && priority == t.priority;
    }
    @Override
    public int hashCode() {
        return Objects.hash(taskId, userId, priority);
    }
}

class TaskManager {
    private final Map<Integer, Task> taskMap;
    private final TreeSet<Task> taskSet;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        taskSet = new TreeSet<>();
        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task old = taskMap.get(taskId);
        if (old != null) taskSet.remove(old);
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        taskSet.add(task);
    }

    public void edit(int taskId, int newPriority) {
        Task old = taskMap.get(taskId);
        if (old == null) return;
        taskSet.remove(old);
        Task updated = new Task(old.userId, old.taskId, newPriority);
        taskMap.put(taskId, updated);
        taskSet.add(updated);
    }

    public void rmv(int taskId) {
        Task t = taskMap.get(taskId);
        if (t == null) return;
        taskSet.remove(t);
        taskMap.remove(taskId);
    }

    public int execTop() {
        if (taskSet.isEmpty()) return -1;
        Task top = taskSet.first();
        taskSet.remove(top);
        taskMap.remove(top.taskId);
        return top.userId;
    }
}
