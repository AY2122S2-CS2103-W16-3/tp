package seedu.address.model.group;

import static java.util.Objects.requireNonNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.person.Person;
import seedu.address.model.task.Task;
import seedu.address.model.task.UniqueTaskList;

/**
 * Represents a Group in ArchDuke.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Group {

    // Identity fields
    private final GroupName groupName;

    // Data fields
    private final Set<Person> persons = new HashSet<>();
    private final UniqueTaskList tasks = new UniqueTaskList();

    /**
     * Constructs a {@code Group}.
     *
     * @param groupName A valid group name.
     */
    public Group(GroupName groupName) {
        requireNonNull(groupName);
        this.groupName = groupName;
    }

    public GroupName getGroupName() {
        return groupName;
    }

    /**
     * Compares as a weaker notion of identity between two groups.
     *
     * @param otherGroup Another group object.
     * @return true as a boolean value if both groups have the same group name.
     */
    public boolean isSameGroup(Group otherGroup) {
        if (otherGroup == this) {
            return true;
        }

        return otherGroup != null
                && otherGroup.getGroupName().equals(getGroupName());
    }

    /**
     * Adds a task into this specific group
     *
     * @param task Tasks to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Retrieves the UniqueTaskList from this specific group
     *
     */
    public UniqueTaskList getTaskList() {
        return tasks;
    }

    /**
     * Returns true if a task with the same identity as {@code task} exists in the group.
     */
    public boolean hasTask(Task task) {
        requireNonNull(task);
        return tasks.contains(task);
    }

    /**
     * Checks if both groups have the same identity and data fields.
     * This defines a stronger notion of equality between two groups.
     *
     * @param other Another group object.
     * @return true as a boolean value if both groups have the same identity and data fields.
     */
    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles null
        if (!(other instanceof Group)) {
            return false;
        }

        Group otherGroup = (Group) other;
        return otherGroup.getGroupName().equals(getGroupName());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(groupName);
    }

    /**
     * Returns a String representation of a group.
     *
     * @return String representation of a group.
     */
    @Override
    public String toString() {
        return String.valueOf(getGroupName());
    }
}
