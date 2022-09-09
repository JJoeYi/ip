package duke;

/**
 * TodoClass is a Task that contains a task description and a boolean to indicate if the task is done.
 */
public class Todo extends Task {

    /**
     * Constructor for Todo.
     *
     * @param description The description of the Task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Constructor for Todo.
     *
     * @param description The description of the Task.
     * @param isDone      Boolean to indicate if the Task is done.
     */
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Returns a Todo that is constructed from a string with a particular format
     * "[T][X] Description"
     *
     * @param s String to be converted to an Todo
     * @return Todo that is constructed from a string with a particular format
     * @throws DukeException When string does not begin with the Todo header "[D]"
     */
    public static Todo stringToTodo(String s) throws DukeException {
        if (!s.startsWith("[T][")) {
            throw new DukeException("This string is not a duke.Todo string!");
        }

        char isDoneString = s.charAt(4); //'[T][X]' checks if X is present
        char X = 'X';
        boolean isDone = isDoneString == X;
        int idxOfTag = s.indexOf("[TAGS]");

        String description = s.substring("[T][X] ".length(), idxOfTag);
        Todo result = new Todo(description, isDone);

        // Extracting tags and adding them
        String tagBack = s.substring(idxOfTag + "[TAGS] ".length());
        String[] tags = tagBack.split("#");

        for (String str: tags) {
            if (str.equals("") || str.equals(" ")) {
                continue;
            }
            result.addTag(str);
        }
        return result;
    }


//    public static void main(String[] args) throws DukeException {
//        String testString = "[T][X] read book";
//        System.out.println(stringToTodo(testString).toString().equals(testString));
//    }
}
