package org.sajt.service.commandprocessor.factory.exception;

public class CommandNotFoundForNameException extends RuntimeException {
    public CommandNotFoundForNameException(String name) {
        super("Command not found for name "+name);
    }
}
