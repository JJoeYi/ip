package commands;

import duke.*;

public class TagCommand implements Command {
    @Override
    public void execute(Parser parser) throws DukeException {
        TaskList taskList = parser.getTaskList();
        String line = parser.getLine();

        if (line.length() <= "tag".length() + 1) {
            throw new DukeException("Please enter the index of Task you would like to add tags to");
        }

        int index = Integer.parseInt(line.replaceAll("[^0-9]", ""));
        assert(index > 0);

        if (index > taskList.size()) {
            throw new DukeException("OOPS!!! Invalid number to delete");
        }

        Task t = taskList.get(index - 1);
        String tagString = line.substring(line.indexOf(String.valueOf(index)) + 1).replace(" ", "");
        t.addTag(tagString);

        Ui.showLine();
        Ui.show("\tNoted. I've tagged this task:");
        Ui.show("\t\t" + t);
        Ui.show("\t\t" + "Tags: " + t.printTags());
        Ui.showLine();
    }
}
