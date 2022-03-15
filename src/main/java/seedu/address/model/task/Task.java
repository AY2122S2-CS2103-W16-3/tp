package seedu.address.model.task;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

public class Task {

    public final TaskName taskName;

    /**
     * Constructs a {@code Task}.
     *
     * @param task A valid task.
     */
    public Task(TaskName task) {
        requireNonNull(task);
        this.taskName = task;
    }

    public TaskName getTask() {
        return taskName;
    }

    /**
     * Compares as a weaker notion of identity between two tasks.
     *
     * @param otherTask Another Task object.
     * @return true as a boolean value if both tasks are the same.
     */
    public boolean isSameTask(Task otherTask) {
        if (otherTask == this) {
            return true;
        }

        return otherTask != null
                && otherTask.getTask().equals(getTask());
    }


    /**
     * Checks if both tasks are the same.
     * This defines a stronger notion of equality between two groups.
     *
     * @param other Another task object.
     * @return true as a boolean value if both tasks are the same.
     */
    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles null
        if (!(other instanceof seedu.address.model.task.Task)) {
            return false;
        }

        seedu.address.model.task.Task otherTask = (seedu.address.model.task.Task) other;
        return otherTask.getTask().equals(getTask());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(taskName);
    }

    /**
     * Returns a String representation of a task.
     *
     * @return String representation of a task.
     */

    @Override
    public String toString() {
        return String.valueOf(taskName.getTaskName());
    }
}
