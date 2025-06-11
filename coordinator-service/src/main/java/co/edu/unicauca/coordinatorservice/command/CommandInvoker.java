package co.edu.unicauca.coordinatorservice.command;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {

    private final List<Command> commandQueue = new ArrayList<Command>();

    public void addCommand(Command command) {
        commandQueue.add(command);
    }

    public void executeCommands() {
        for (Command command : commandQueue) {
            command.execute();
        }
        commandQueue.clear();
    }
}