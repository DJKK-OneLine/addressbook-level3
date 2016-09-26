package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Comparator;
import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class ListSortedCommand extends Command {

    public static final String COMMAND_WORD = "listsorted";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Displays all persons in the address book as a list with index numbers sorted by name.\n\t"
            + "Example: " + COMMAND_WORD;

    
    class NameComparator implements Comparator<ReadOnlyPerson> {
    	@Override
    	public int compare(ReadOnlyPerson a, ReadOnlyPerson b){
    		String aName = a.getName().toString();
    		String bName = b.getName().toString();
    		return aName.compareTo(bName);
    	}
    }
    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        allPersons.sort(new NameComparator());
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
