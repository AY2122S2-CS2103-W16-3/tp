package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.group.Group;

/**
 * A utility class containing a list of {@code Group} objects to be used in tests.
 */
public class TypicalGroups {
    public static final Group NUS_FINTECH_SOCIETY = new GroupBuilder().withGroupName("NUS Fintech Society").build();
    public static final Group NUS_DATA_SCIENCE_SOCIETY =
            new GroupBuilder().withGroupName("NUS Data Science Society").build();

    /**
     * Returns an {@code AddressBook} with all the typical groups.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Group group : getTypicalGroups()) {
            ab.addGroup(group);
        }
        return ab;
    }

    public static List<Group> getTypicalGroups() {
        return new ArrayList<>(Arrays.asList(NUS_FINTECH_SOCIETY, NUS_DATA_SCIENCE_SOCIETY));
    }
}
