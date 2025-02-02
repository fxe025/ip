package TaskList;

import Parser.DukeExceptions;
import Parser.MarkTask;
import Ui.PrintText;

import java.util.ArrayList;

/**
 * Represents a command to delete a task form an existing list of tasks.
 */
public class DeleteTask {
    /**
     * Delete a task from the stored list based on the user input.
     *
     * @param userInputWords The task to be printed.
     * @param tasks Arraylist of tasks stored.
     */
    public static void delete(String[] userInputWords, ArrayList<Task> tasks) {
        int indexToDelete = -1;
        try {
            indexToDelete = MarkTask.findIndexToMark(userInputWords, tasks);
        } catch(ArrayIndexOutOfBoundsException e) {
            PrintText.printWithLinebreak("Index out of range");
            return;
        } catch(DukeExceptions.InvalidItemException e) {
            PrintText.printWithLinebreak("Please enter a valid item to delete.");
            return;
        }

        int indexInList = indexToDelete - 1;
        Task taskToDelete = tasks.get(indexInList);
        char type = taskToDelete.getTypeIcon();
        String typeMark = "[" + type + "]";
        String statusMark = "[" + taskToDelete.getStatusIcon() + "] ";
        PrintText.printWithLinebreak("Noted. I've removed this task:\n" +
                typeMark + statusMark + taskToDelete.description);
        tasks.remove(taskToDelete);
    }
}
