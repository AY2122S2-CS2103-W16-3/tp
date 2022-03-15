package seedu.address.model.group;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class GroupNameTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new GroupName(null));
    }

    @Test
    public void constructor_invalidGroupName_throwsIllegalArgumentException() {
        String invalidGroupName = "";
        assertThrows(IllegalArgumentException.class, () -> new GroupName(invalidGroupName));
    }

    @Test
    public void isValidGroupName() {
        // null group name
        assertThrows(NullPointerException.class, () -> GroupName.isValidGroupName(null));

        // invalid group name
        assertFalse(GroupName.isValidGroupName("")); // empty string
        assertFalse(GroupName.isValidGroupName(" ")); // spaces only

        // valid name
        assertTrue(GroupName.isValidGroupName("coffee enthusiasts")); // alphabets only
        assertTrue(GroupName.isValidGroupName("31415")); // numbers only
        assertTrue(GroupName.isValidGroupName("2nd year students")); // alphanumeric characters
        assertTrue(GroupName.isValidGroupName("NUS Fintech Society")); // with capital letters
        assertTrue(GroupName.isValidGroupName("NUS Statistics and Data Science Society")); // long names
        assertTrue(GroupName.isValidGroupName("important*")); // contains non-alphanumeric characters
        assertTrue(GroupName.isValidGroupName("^")); // only non-alphanumeric characters
    }
}
