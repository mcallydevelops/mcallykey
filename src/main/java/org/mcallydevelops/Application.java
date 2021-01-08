package org.mcallydevelops;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Context context = Context.createDefaultContext();
        new Server(context).run();
    }
}
