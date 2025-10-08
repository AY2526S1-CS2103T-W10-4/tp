package seedu.address.logic.parser;

import static seedu.address.logic.parser.ParserUtil.parseIndex;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.MarkCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new PresentCommand object
 * Accepts leading/trailing spaces; requires a whole-number index.
 */
public class MarkCommandParser implements Parser<MarkCommand> {

    @Override
    public MarkCommand parse(String args) throws ParseException {
        String trimmed = args.trim();
        if (trimmed.isEmpty()) {
            // Let parseIndex throw the standard index parse error for non-positive/empty inputs
        }
        Index index = parseIndex(trimmed);
        return new MarkCommand(index);
    }
}
