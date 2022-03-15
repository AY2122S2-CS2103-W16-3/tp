package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String USERGUIDE_URL = "https://ay2122s2-cs2103-w16-3.github.io/tp/UserGuide.html";
    public static final String HELP_MESSAGE = "Refer to the user guide: " + USERGUIDE_URL;

    public static final String LIST_COMMAND_DESC = "Listing all persons: ";
    public static final String LIST_COMMAND = "list";
    public static final String LIST_COMMAND_EXAMPLE = "Shows a list of all student contacts in ArchDuke.";

    public static final String EXIT_COMMAND_DESC = "Exiting the program: ";
    public static final String EXIT_COMMAND = "exit";
    public static final String EXIT_COMMAND_EXAMPLE = "Exits the program.";

    public static final String ADD_COMMAND_DESC = "Add student contact information: ";
    public static final String ADD_COMMAND = "add n/NAME p/PHONE_NUMBER e/EMAIL a/ACADEMIC_MAJOR [t/TAG]";
    public static final String ADD_COMMAND_EXAMPLE = "Adds a student contact information to ArchDuke.";

    public static final String ADD_GROUP_COMMAND_DESC = "Create a group: ";
    public static final String ADD_GROUP_COMMAND = "addgroup g/GROUP_NAME";
    public static final String ADD_GROUP_COMMAND_EXAMPLE = "Creates a group in ArchDuke.";

    public static final String ASSIGN_COMMAND_DESC = "Assign a student to a group: ";
    public static final String ASSIGN_COMMAND = "assign INDEX g/GROUP_NAME";
    public static final String ASSIGN_COMMAND_EXAMPLE = "Assigns a student to an existing group in ArchDuke.";

    public static final String ADD_TASK_COMMAND_DESC = "Add a task to a group: ";
    public static final String ADD_TASK_COMMAND = "addtask t/TASK_NAME g/GROUP_NAME";
    public static final String ADD_TASK_COMMAND_EXAMPLE = "Adds a task to the specified existing group.";

    public static final String VIEW_TASK_COMMAND_DESC = "Displays the tasks in a group: ";
    public static final String VIEW_TASK_COMMAND = "viewtask g/GROUP_NAME";
    public static final String VIEW_TASK_COMMAND_EXAMPLE = "Displays the tasks from the specified existing group.";

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    @FXML
    private Button copyButton;

    @FXML
    private Label helpMessage;

    @FXML
    private Label listCommandDesc;

    @FXML
    private Label listCommand;

    @FXML
    private Label listCommandExample;

    @FXML
    private Label exitCommandDesc;

    @FXML
    private Label exitCommand;

    @FXML
    private Label exitCommandExample;

    @FXML
    private Label addCommandDesc;

    @FXML
    private Label addCommand;

    @FXML
    private Label addCommandExample;

    @FXML
    private Label addGroupCommandDesc;

    @FXML
    private Label addGroupCommand;

    @FXML
    private Label addGroupCommandExample;

    @FXML
    private Label assignCommandDesc;

    @FXML
    private Label assignCommand;

    @FXML
    private Label assignCommandExample;

    @FXML
    private Label addTaskCommandDesc;

    @FXML
    private Label addTaskCommand;

    @FXML
    private Label addTaskCommandExample;

    @FXML
    private Label viewTaskCommandDesc;

    @FXML
    private Label viewTaskCommand;

    @FXML
    private Label viewTaskCommandExample;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        helpMessage.setText(HELP_MESSAGE);
        listCommandDesc.setText(LIST_COMMAND_DESC);
        listCommand.setText(LIST_COMMAND);
        listCommandExample.setText(LIST_COMMAND_EXAMPLE);
        exitCommandDesc.setText(EXIT_COMMAND_DESC);
        exitCommand.setText(EXIT_COMMAND);
        exitCommandExample.setText(EXIT_COMMAND_EXAMPLE);
        addCommandDesc.setText(ADD_COMMAND_DESC);
        addCommand.setText(ADD_COMMAND);
        addCommandExample.setText(ADD_COMMAND_EXAMPLE);
        addGroupCommandDesc.setText(ADD_GROUP_COMMAND_DESC);
        addGroupCommand.setText(ADD_GROUP_COMMAND);
        addGroupCommandExample.setText(ADD_GROUP_COMMAND_EXAMPLE);
        assignCommandDesc.setText(ASSIGN_COMMAND_DESC);
        assignCommand.setText(ASSIGN_COMMAND);
        assignCommandExample.setText(ASSIGN_COMMAND_EXAMPLE);
        addTaskCommandDesc.setText(ADD_TASK_COMMAND_DESC);
        addTaskCommand.setText(ADD_TASK_COMMAND);
        addTaskCommandExample.setText(ADD_TASK_COMMAND_EXAMPLE);
        viewTaskCommandDesc.setText(VIEW_TASK_COMMAND_DESC);
        viewTaskCommand.setText(VIEW_TASK_COMMAND);
        viewTaskCommandExample.setText(VIEW_TASK_COMMAND_EXAMPLE);
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
