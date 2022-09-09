package duke;

import java.util.ArrayList;

/**
 * Task is a general class that consists of the task description and a boolean to indicate if the task is done.
 */
public class Task {
    protected String description;
    protected boolean isDone;
    protected ArrayList<Tag> tagList;

    /**
     * Constructor for Task.
     *
     * @param description Description of the Task to do.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Constructor for Task.
     *
     * @param description Description of the Task to do.
     * @param isDone      Boolean to indicate if the Task is done.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsUndone() {
        this.isDone = false;
    }

    public void addTag(String s) {
        if (tagList == null) {
            tagList = new ArrayList<>();
        }

        Tag tag = new Tag(s);
        tagList.add(tag);
    }

    public void removeTag(String s) {
        if (tagList == null) {
            return;
        }

        Tag tagToRemove = new Tag(s);
        tagList.remove(tagToRemove);
    }

    public String printTags() {
        if (tagList == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (Tag tag: tagList) {
            result.append(tag.toString()).append(" ");
        }
        return result.toString();
    }

    public boolean isTagsEmpty() {
        return tagList == null || tagList.isEmpty();
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public static void main(String[] args) {
        Task t = new Task("test task");
        t.addTag("tag1");
        t.addTag("tag2");
        System.out.println(t.printTags());
    }
}