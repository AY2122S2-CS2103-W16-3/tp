package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.group.Group;
import seedu.address.model.task.UniqueTaskList;

/**
 * A UI component that displays information of a {@code Group}.
 */
public class GroupCard extends UiPart<Region> {

    private static final String FXML = "GroupListCard.fxml";

    public final Group group;

    @FXML
    private HBox cardPane;
    @FXML
    private Label groupName;
    @FXML
    private Label id;
    @FXML
    private FlowPane taskName;
    @FXML
    private Label taskId;
    @FXML
    private Label taskTitle;

    /**
     * Creates a {@code GroupCode} with the given {@code Group} and index to display.
     */
    public GroupCard(Group group, int displayedIndex) {
        super(FXML);
        this.group = group;
        id.setText(displayedIndex + ". ");
        groupName.setText(group.getGroupName().groupName);
        taskTitle.setText("Task List:");

        UniqueTaskList taskList = group.getTaskList();

        group.getTaskList().getInternalList().stream()
                .sorted(Comparator.comparing(task -> task.taskName.taskName))
                .forEach(task -> taskName.getChildren().add(new Label(task.taskName.taskName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles null
        if (!(other instanceof GroupCard)) {
            return false;
        }

        // state check
        GroupCard card = (GroupCard) other;
        return id.getText().equals(card.id.getText())
                && group.equals(card.group);
    }
}
