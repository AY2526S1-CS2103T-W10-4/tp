package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Marks a member as present for the current session.
 * Command usage: present INDEX
 */
public class MarkCommand extends Command {

    public static final String COMMAND_WORD = "present";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Mark the member at the given index as present.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_SUCCESS = "Member '%s' marked present!";
    public static final String MESSAGE_INVALID_INDEX = Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX;

    private final Index targetIndex;

    public MarkCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(MESSAGE_INVALID_INDEX);
        }

        Person personToMark = lastShownList.get(targetIndex.getZeroBased());

        // Create a new Person with isPresent = true (idempotent; always succeeds)
        Person marked = personToMark.withPresence(true);

        model.setPerson(personToMark, marked);
        return new CommandResult(String.format(MESSAGE_SUCCESS, marked.getName().fullName));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit
                || (other instanceof MarkCommand
                && targetIndex.equals(((MarkCommand) other).targetIndex));
    }
}
