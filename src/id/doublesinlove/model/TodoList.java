package id.doublesinlove.model;

import java.util.ArrayList;

/**
 * doublesinlove © 2017.
 */

public class TodoList extends ArrayList<Todo> {
    public void addTodo(Todo todo) {
        this.add(todo);
    }

    public Todo getTodo(int index) {
        return this.get(index);
    }
}
