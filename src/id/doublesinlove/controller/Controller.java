package id.doublesinlove.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import id.doublesinlove.model.TodoList;
import id.doublesinlove.view.WarningDialog;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    /* Attributes */
    @FXML
    private JFXListView<String> todoListView = new JFXListView<>();

    @FXML
    private JFXButton deleteButton;

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
        todoListView.setExpanded(true);
        todoListView.setDepth(1);
    }

    @FXML
    public void newTodo () throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/CreateView.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage createTodo = new Stage();
            createTodo.setScene(new Scene(root1, 480, 240));
            CreateController createController = fxmlLoader.getController();
            createController.setTodoListView(todoListView);
            createController.setTodoList(todoList);
            createTodo.setTitle("New Todo");
            createTodo.setResizable(false);
            createTodo.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteTodo() {
        int index = todoListView.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            System.out.println("ERROR");
        } else {
            todoListView.getItems().remove(index);
        }

    }
}


