package Config;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author arab
 */
public abstract class TestConfig {
    protected final ByteArrayOutputStream printedContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
	System.setOut(new PrintStream(printedContent));
    }

    @After
    public void cleanUpStreams() {
	System.setOut(null);
    }
}
