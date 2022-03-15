package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GROUP_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.group.Group;
import seedu.address.model.task.Task;

public class AddTaskCommand extends Command {

    public static final String COMMAND_WORD = "addtask";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a task to a group."
            + "Parameters: "
            + PREFIX_TASK + "TASK_NAME "
            + PREFIX_GROUP_NAME + "GROUP_NAME \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TASK + "v1.2 user guide "
            + PREFIX_GROUP_NAME + "CS2103-W16-3 \n";

    public static final String MESSAGE_SUCCESS = "New task added: %1$s";
    public static final String MESSAGE_DUPLICATE_TASK = "This task is already in the group";
    public static final String MESSAGE_NON_EXISTENT_GROUP = "This group does not exist in the list";

    private final Task taskToAdd;
    private final Group specificGroup;

    /**
     * Creates an AddTaskCommand to add the specified {@code task}
     * to the specified {@code group}
     *
     * @param group group to be added to ArchDuke.
     */
    public AddTaskCommand(Task task, Group group) {
        requireAllNonNull(group);
        requireAllNonNull(task);
        this.taskToAdd = task;
        this.specificGroup = group;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {

        if (model.hasGroup(specificGroup)) { //check whether the specified group exists
            if (model.hasTask(taskToAdd, specificGroup)) {
                throw new CommandException(MESSAGE_DUPLICATE_TASK);
            }
            model.addTask(taskToAdd, specificGroup);
            return new CommandResult(String.format(MESSAGE_SUCCESS, taskToAdd));
        } else {
            throw new CommandException(MESSAGE_NON_EXISTENT_GROUP);
        }
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddTaskCommand)) {
            return false;
        }

        // state check
        AddTaskCommand e = (AddTaskCommand) other;
        return taskToAdd.equals(e.taskToAdd);
    }
}
