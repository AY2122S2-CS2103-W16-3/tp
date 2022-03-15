package seedu.address.model.group;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Group's name in ArchDuke.
 * Guarantees: immutable; is valid as declared in {@link #isValidGroupName(String)}
 */
public class GroupName {

    public static final String MESSAGE_CONSTRAINTS =
            "Group name can take any values, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String groupName;

    /**
     * Constructs a {@code GroupName}.
     *
     * @param groupName A valid group name.
     */
    public GroupName(String groupName) {
        requireNonNull(groupName);
        checkArgument(isValidGroupName(groupName), MESSAGE_CONSTRAINTS);
        this.groupName = groupName;
    }

    /**
     * Returns true if a given string is a valid group name.
     */
    public static boolean isValidGroupName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns a String representation of a group name.
     *
     * @return String representation of a group name.
     */
    @Override
    public String toString() {
        return groupName;
    }

    /**
     * Checks whether the specified other object is equal to GroupName object.
     *
     * @param other The other object.
     * @return true as boolean value if the specified other object is equal to the GroupName object.
     */
    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles null
        if (!(other instanceof GroupName)) {
            return false;
        }

        // state check
        GroupName e = (GroupName) other;
        return groupName.equals(e.groupName);
    }
}
