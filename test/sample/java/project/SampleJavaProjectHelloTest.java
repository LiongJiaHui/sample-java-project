package sample.java.project;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SampleJavaProjectHelloTest {

    @Test
    public void testSayHelloDefault() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        new SampleJavaProject().sayHello();

        System.setOut(original);
        String expected = "Hello, world!" + System.lineSeparator();
        assertEquals("default hello should be to 'world'", expected, out.toString());
    }

    @Test
    public void testSayHelloCustom() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        new SampleJavaProject("UTAR", false, false).sayHello();

        System.setOut(original);
        String expected = "Hello" + System.lineSeparator();
        assertEquals("custom hello should use provided name", expected, out.toString());
    }
}
