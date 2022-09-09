package duke;

/**
 * This class represents a Tag for Tasks
 */
public class Tag {
    private String tagString;

    public Tag(String s) {
        tagString = s;
    }

    @Override
    public String toString() {
        return "#" + tagString;
    }
}
