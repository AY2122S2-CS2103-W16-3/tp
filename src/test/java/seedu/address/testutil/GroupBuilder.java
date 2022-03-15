package seedu.address.testutil;

import seedu.address.model.group.Group;
import seedu.address.model.group.GroupName;

/**
 * A utility class to help with building Group objects.
 */
public class GroupBuilder {
    public static final String GROUP_NAME = "NUS Fintech Society";

    private GroupName groupName;

    /**
     * Creates a {@code GroupBuilder} with the default details.
     */
    public GroupBuilder() {
        groupName = new GroupName(GROUP_NAME);
    }

    /**
     * Initializes the GroupBuilder with the data of {@code groupToCopy}.
     */
    public GroupBuilder(Group groupToCopy) {
        groupName = groupToCopy.getGroupName();
    }

    /**
     * Sets the {@code GroupName} of the {@code Group} that we are building.
     */
    public GroupBuilder withGroupName(String groupName) {
        this.groupName = new GroupName(groupName);
        return this;
    }

    public Group build() {
        return new Group(groupName);
    }
}
