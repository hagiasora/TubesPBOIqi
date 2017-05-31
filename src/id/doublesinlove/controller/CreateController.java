package id.doublesinlove.controller;

import com.jfoenix.controls.*;
import id.doublesinlove.model.Todo;
import id.doublesinlove.model.TodoList;
import id.doublesinlove.view.WarningDialog;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;


/**
 * doublesinlove © 2017.
 */
public class CreateController implements Initializable {
    /* Class Attributes */
    @FXML
    private StackPane stackPane;

    @FXML
    private JFXTextArea todoInput;

    @FXML
    private JFXToggleButton reminderToggle;

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    private JFXTimePicker timePicker;

    @FXML
    private JFXListView<String> todoListView = new JFXListView<>();

    private TodoList todoList = new TodoList();


    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setDisable(true);
        timePicker.setDisable(true);
    }

    /**
     * Called to set this controller's JFXListView as Parent's one.
     *
     * @param todoListView The parent's JFXListView
     * */
    void setTodoListView(JFXListView<String> todoListView) {
        this.todoListView = todoListView;
    }

    /**
     * Called to ser this controller's TodoList as parent's one
     *
     * @param todoList The parent's TodoList */
    void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }

    /**
     * Get input text from user and save it in JFXListView Collection
     * Called when user click SAVE Button.
     */
    @FXML
    public void saveToDo() {
        if (datePicker.isDisabled() && timePicker.isDisabled()) {
            String todo = todoInput.getText();                                  // Get Text from Text Area
            if (todo.equals("")) {                                              // Warn user about blank input
                WarningDialog warningDialog = new WarningDialog("Todo");
                warningDialog.showDialog(stackPane);
            } else {
                todoListView.getItems().add(todo);
                todoInput.setText("");
            }
        } else {
            String todo = todoInput.getText();
            LocalDate date = datePicker.getValue();                             // Get Date from DatePicker
            LocalTime time = timePicker.getValue();                             // Get Time from TimePicker
            if (todo.equals("")) {                                              // Warn user about blank input
                WarningDialog warningDialog = new WarningDialog("Todo");
                warningDialog.showDialog(stackPane);
            } else if (date == null) {
                WarningDialog warningDialog = new WarningDialog("Date");
                warningDialog.showDialog(stackPane);
            } else if (time == null) {
                WarningDialog warningDialog = new WarningDialog("Time");
                warningDialog.showDialog(stackPane);
            } else {
                todoListView.getItems().add(todo);
                Todo newEntry = new Todo();
                newEntry.setContent(todo);
                newEntry.setDate(date);
                newEntry.setTime(time);
                todoList.addTodo(newEntry);
                todoInput.setText("");
            }
        }

    }

    @FXML
    public void setReminderToggle(){
        if (reminderToggle.isSelected()) {
            datePicker.setDisable(false);
            timePicker.setDisable(false);
        } else {
            datePicker.setDisable(true);
            timePicker.setDisable(true);
        }
    }
}
