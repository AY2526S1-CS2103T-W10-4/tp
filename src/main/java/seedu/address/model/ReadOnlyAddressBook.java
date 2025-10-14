package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.member.Member;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyAddressBook {

    /**
     * Returns an unmodifiable view of the list.
     * This list will not contain any duplicate members.
     */
    ObservableList<Member> getMemberList();

}
