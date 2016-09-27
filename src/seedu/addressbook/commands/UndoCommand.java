package seedu.addressbook.commands;

public class UndoCommand extends Command {

    public static final String COMMAND_WORD = "undo";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Undoes the previous modification to the address book.\n\t"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Undone!";
    public static final String MESSAGE_FAILURE = "No edits have been done to the address book yet!";

    public UndoCommand() {}

    @Override
    public CommandResult execute() throws Exception {
    	if (addressBook.havePreviousState()) {
    		return new CommandResult(MESSAGE_FAILURE);
    	}
        addressBook.undo();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
