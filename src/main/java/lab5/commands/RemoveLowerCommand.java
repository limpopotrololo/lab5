package lab5.commands;

import lab5.exeptions.*;
import lab5.utility.ArgumentLoader;
import lab5.utility.CollectionManager;
import lab5.utility.IOManager;

/**
 * "remove_lower" command, remove elements which lower than current
 */
public class RemoveLowerCommand extends Command {
    private final CollectionManager collectionManager;
    private final IOManager ioManager;

    public RemoveLowerCommand(CollectionManager collectionManager, IOManager ioManager) {
        this.collectionManager = collectionManager;
        this.ioManager = ioManager;
    }
    @Override
    public String getName() {
        return "remove_lower";
    }

    @Override
    public String getDescription() {
        return "Удаляет все элементы коллекции меньше чем введенный";
    }

    @Override
    public void run(ArgumentLoader arguments) throws EmptyElement, IncorrectData {
        try {
            arguments.validateCount(0);
            if (collectionManager.removeLower(arguments))
                ioManager.println("Элемент удален");
            else
                ioManager.printerr("коллекция пуста");
        } catch (IllegalArgumentException e) {
            ioManager.println("Неверное количество аргументов");
        }
    }
}
