package greetings.cli;

import greetings.api.Greeter;
import greetings.impl.DefaultGreeter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        Greeter greeter = new DefaultGreeter();
        String subject = subjectFrom(args);
        String greetings = greeter.greetingsFor(subject);
        System.out.println(greetings);
    }

    private static String subjectFrom(String[] args) throws IOException {
        if (args.length > 0) {
            return String.join(" ", args);
        } else {
            return loadDefaultSubject();
        }
    }

    private static String loadDefaultSubject() throws IOException {
        try (InputStream input = Main.class.getResourceAsStream("default-subject.properties")) {
            Properties props = new Properties();
            props.load(input);
            return props.getProperty("subject");
        }
    }
}
