package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PhoneTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Phone(null));
    }

    @Test
    public void constructor_invalidPhone_throwsIllegalArgumentException() {
        String invalidPhone = "";
        assertThrows(IllegalArgumentException.class, () -> new Phone(invalidPhone));
    }

    @Test
    public void isValidPhone() {
        // null phone number
        assertThrows(NullPointerException.class, () -> Phone.isValidPhone(null));

        // invalid phone numbers
        assertFalse(Phone.isValidPhone("")); // empty string
        assertFalse(Phone.isValidPhone(" ")); // spaces only
        assertFalse(Phone.isValidPhone("91")); // fewer than 8 digits
        assertFalse(Phone.isValidPhone("8123456")); // 7 digits
        assertFalse(Phone.isValidPhone("71234567")); // 8 digits but does not start with 8 or 9
        assertFalse(Phone.isValidPhone("00123456")); // 8 digits but starts with 0
        assertFalse(Phone.isValidPhone("phone")); // non-numeric
        assertFalse(Phone.isValidPhone("9011p041")); // alphabet within digits
        assertFalse(Phone.isValidPhone("124293842033123")); // too long
        assertFalse(Phone.isValidPhone("911")); // exactly 3 numbers

        // valid phone numbers (exactly 8 digits, start with 8 or 9)
        assertTrue(Phone.isValidPhone("9312 1534")); // spaces within digits
        assertTrue(Phone.isValidPhone("93121534"));
        assertTrue(Phone.isValidPhone("83121534"));
    }

    @Test
    public void equals() {
        Phone phone = new Phone("88888888");

        // same values -> returns true
        assertTrue(phone.equals(new Phone("88888888")));

        // same object -> returns true
        assertTrue(phone.equals(phone));

        // null -> returns false
        assertFalse(phone.equals(null));

        // different types -> returns false
        assertFalse(phone.equals(5.0f));

        // different values -> returns false
        assertFalse(phone.equals(new Phone("99999999")));
    }
}
