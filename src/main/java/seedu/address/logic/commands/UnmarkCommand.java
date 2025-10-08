package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Unmarks a member as present for the current session.
 * Command usage: unmark INDEX
 */
public class UnmarkCommand extends Command {

    public static final String COMMAND_WORD = "unmark";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Unmark the member at the given index as present.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 2";

    public static final String MESSAGE_SUCCESS = "Member '%s' unmarked!";
    public static final String MESSAGE_INVALID_INDEX = Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX;

    private final Index targetIndex;

    public UnmarkCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(MESSAGE_INVALID_INDEX);
        }

        Person personToUnmark = lastShownList.get(targetIndex.getZeroBased());

        // Create a new Person with isPresent = false
        Person unmarked = personToUnmark.withPresence(false);

        model.setPerson(personToUnmark, unmarked);
        return new CommandResult(String.format(MESSAGE_SUCCESS, unmarked.getName().fullName));
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof UnmarkCommand
                && targetIndex.equals(((UnmarkCommand) other).targetIndex));
    }
}
