package lab5.start;

import lab5.exeptions.*;

/**
 * Abstract form for application's behavior
 */
public abstract class AbstractApplication {
    private static boolean state = false;

    public abstract void run() throws EmptyElement, IncorrectData;

    public void onStart() {

    }

    public final void start() throws EmptyElement, IncorrectData {
        state = true;
        onStart();
        while (state) {
            run();
        }

    }

    public static void onStop() {
        state = false;

    }


}
