package greetings.impl;

import greetings.api.Greeter;

public class DefaultGreeter implements Greeter {

    @Override
    public String greetingsFor(String subject) {
        return "Hello, " + subject + '!';
    }
}
