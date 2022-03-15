package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's academic major in ArchDuke.
 * Guarantees: immutable; is valid as declared in {@link #isValidAcademicMajor(String)}
 */
public class AcademicMajor {

    public static final String MESSAGE_CONSTRAINTS = "Academic major can take any values, and it should not be blank";

    /*
     * The first character of the academic major must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs an {@code AcademicMajor}.
     *
     * @param academicMajor A valid academic major.
     */
    public AcademicMajor(String academicMajor) {
        requireNonNull(academicMajor);
        checkArgument(isValidAcademicMajor(academicMajor), MESSAGE_CONSTRAINTS);
        value = academicMajor;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidAcademicMajor(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AcademicMajor // instanceof handles nulls
                && value.equals(((AcademicMajor) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
