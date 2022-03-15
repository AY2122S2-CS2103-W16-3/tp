package seedu.address.model.task;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Task's name in Group.
 * Guarantees: immutable; is valid as declared in {@link #isValidTaskName(String)}
 */
public class TaskName {

    public static final String MESSAGE_CONSTRAINTS =
            "Task can take any values, and it should not be blank";

    /*
     * The first character of the task must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";
    public final String taskName;

    /**
     * Constructs a {@code TaskName}.
     *
     * @param taskName A valid task name.
     */
    public TaskName(String taskName) {
        requireNonNull(taskName);
        checkArgument(isValidTaskName(taskName), MESSAGE_CONSTRAINTS);
        this.taskName = taskName;
    }

    /**
     * Returns true if a given string is a valid task name.
     */
    public static boolean isValidTaskName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String getTaskName() {
        return taskName;
    }

    /**
     * Returns a String representation of a task name.
     *
     * @return String representation of a task name.
     */
    @Override
    public String toString() {
        return taskName;
    }

    /**
     * Checks whether the specified other object is equal to TaskName object.
     *
     * @param other The other object.
     * @return true as boolean value if the specified other object is equal to the TaskName object.
     */
    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles null
        if (!(other instanceof seedu.address.model.task.TaskName)) {
            return false;
        }

        // state check
        seedu.address.model.task.TaskName e = (seedu.address.model.task.TaskName) other;
        return taskName.equals(e.taskName);
    }
}
