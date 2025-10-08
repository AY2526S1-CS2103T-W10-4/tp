package seedu.address.logic.parser;

import static seedu.address.logic.parser.ParserUtil.parseIndex;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.UnmarkCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new UnmarkCommand object
 * Accepts leading/trailing spaces; requires a whole-number index.
 */
public class UnmarkCommandParser implements Parser<UnmarkCommand> {

    @Override
    public UnmarkCommand parse(String args) throws ParseException {
        String trimmed = args.trim();
        Index index = parseIndex(trimmed);
        return new UnmarkCommand(index);
    }
}
