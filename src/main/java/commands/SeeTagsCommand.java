package commands;

import duke.*;

public class SeeTagsCommand implements Command {
    @Override
    public void execute(Parser parser) throws DukeException {
        TaskList taskList = parser.getTaskList();
        String line = parser.getLine();

        for (Task t: taskList.getTaskArr()) {
            if (!t.isTagsEmpty()) {
                Ui.show("Task: " + t + "Tags: " + t.printTags());
            }
        }
    }
}
