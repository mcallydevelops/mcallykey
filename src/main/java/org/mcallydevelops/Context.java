package org.mcallydevelops;

public class Context {

    private final IntegerDataEngine integerDataEngine;
    private final Configuration configuration;

    public Context(IntegerDataEngine integerDataEngine, Configuration configuration) {
        this.integerDataEngine = integerDataEngine;
        this.configuration = configuration;
    }

    public static Context createDefaultContext() {
        Configuration configuration = Configuration.loadDefaultConfiguration();
        return new Context(new IntegerDataEngine(), configuration);
    }

    public IntegerDataEngine getIntegerDataEngine() {
        return integerDataEngine;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
