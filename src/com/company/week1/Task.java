package com.company.week1;

/**
 * Created by 016308 on 2/13/2019.
 */
public class Task {
    private String title;
    private String description;
    private int priority; //0-5, 5 highest

    public Task(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public Task() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "\ntitle='" + title + '\'' +
                ",\n description='" + description + '\'' +
                ",\n priority=" + priority +
                '}';
    }
}
