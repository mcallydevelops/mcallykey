package org.mcallydevelops;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Context {

    private final IntegerDataEngine integerDataEngine;
    private final AuthenticationHandler authenticationHandler;
    private final ObjectMapper objectMapper;
    private final Configuration configuration;

    public Context(IntegerDataEngine integerDataEngine, AuthenticationHandler authenticationHandler, ObjectMapper objectMapper, Configuration configuration) {
        this.integerDataEngine = integerDataEngine;
        this.authenticationHandler = authenticationHandler;
        this.objectMapper = new ObjectMapper();
        this.configuration = configuration;
    }

    public static Context createDefaultContext() {
        Configuration configuration = Configuration.loadDefaultConfiguration();
        ObjectMapper objectMapper = new ObjectMapper();
        return new Context(new IntegerDataEngine(), new AuthenticationHandler(objectMapper), objectMapper, configuration);
    }

    public IntegerDataEngine getIntegerDataEngine() {
        return integerDataEngine;
    }

    public AuthenticationHandler getAuthenticationHandler() {
        return authenticationHandler;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
