package lab5.commands;

import lab5.data.SpaceMarine;
import lab5.exeptions.*;
import lab5.utility.ArgumentLoader;
import lab5.utility.CollectionManager;
import lab5.utility.IOManager;
import lab5.utility.SpaceMarineArgumentLoader;

/**
 * "update" command, update collection item by id
 */
public class UpdateIdCommand extends Command {
    CollectionManager collectionManager;
    IOManager ioManager;

    public UpdateIdCommand(CollectionManager collectionManager, IOManager ioManager) {
        this.collectionManager = collectionManager;
        this.ioManager = ioManager;
    }

    /**
     * execute command
     * @param arguments
     * @throws EmptyElement
     * @throws IncorrectData
     */
    @Override
    public void run(ArgumentLoader arguments) throws EmptyElement, IncorrectData {
        try {
            arguments.validateCount(1);
            Long id = Long.parseLong(arguments.getStrArguments()[0]);
            if (collectionManager.getSize() == 0)
                ioManager.printerr("коллекция пуста");
            else {
                SpaceMarine findMarine = collectionManager.findElementById(id);
                if (findMarine == null)
                    ioManager.printerr("в коллекции нет элемента с данным id");
                else {
                    SpaceMarine newSpaceMarine = ((SpaceMarineArgumentLoader) arguments).loadSpaceMarin();
                    collectionManager.addMarine(newSpaceMarine);
                    ioManager.println("____Элемент обновлен____");
                }
            }
        } catch (NumberFormatException e) {
            ioManager.printerr("Аргумент неверного формата");
        } catch (IllegalArgumentException e) {
            ioManager.printerr("Неверное количество аргументов");
        }

    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return "Обновляет элемент по введенному id";
    }
}
