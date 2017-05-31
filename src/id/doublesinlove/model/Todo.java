package id.doublesinlove.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * doublesinlove © 2017.
 */
public class Todo {
    private LocalDate date;
    private LocalTime time;
    private String content;

    public Todo() {}

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
