package Lab5.Commands;

import Lab5.Exeptions.*;
import Lab5.Utility.ArgumentLoader;
import Lab5.Utility.CollectionManager;
import Lab5.Utility.IOManager;

public class PrintUniqueHealthCommand extends Command {
    private final CollectionManager collectionManager;
    private final IOManager ioManager;

    public PrintUniqueHealthCommand(CollectionManager collectionManager, IOManager ioManager) {
        this.collectionManager = collectionManager;
        this.ioManager = ioManager;
    }

    @Override
    public void run(ArgumentLoader arguments) throws EmptyElement, IncorrectData {
        try {
            arguments.validateCount(0);
            if (collectionManager.getUniqueHealth().isEmpty()) throw new IncorrectData();
            for (Double item : collectionManager.getUniqueHealth())
                ioManager.println(item);
        } catch (IllegalArgumentException e) {
            ioManager.println("Неверное количество аргументов");
        } catch (IncorrectData incorrectData) {
            ioManager.println("Коллекция пока пуста");
        }


    }

    @Override
    public String getName() {
        return "print_unique_health";
    }

    @Override
    public String getDescription() {
        return "Выводит уникальные значение поля health";
    }
}