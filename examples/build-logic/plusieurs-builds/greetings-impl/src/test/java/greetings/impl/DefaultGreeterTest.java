package greetings.impl;

import greetings.api.Greeter;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class DefaultGreeterTest {

    @Test
    public void testDefaultGreeter() {
        Greeter greeter = new DefaultGreeter();
        String greetings = greeter.greetingsFor("Test");
        assertThat(greetings, equalTo("Hello, Test!"));
    }
}
