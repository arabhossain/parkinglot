package Config;


import com.gojek.carparking.ManageParking;
import console.Console;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author arab
 */
public abstract class TestConfig {
    protected ByteArrayOutputStream printedContent;
    protected ManageParking manageParking =  new ManageParking();
    protected Console console;

    @Before
    public void setUpStreams() {
        printedContent = new ByteArrayOutputStream();
	System.setOut(new PrintStream(printedContent));
        manageParking.restParking();
        console = new Console();;
    }

    @After
    public void cleanUpStreams() {
	System.setOut(null);
    }
    
    public void restStream(){
        this.cleanUpStreams();
        printedContent = new ByteArrayOutputStream();
	System.setOut(new PrintStream(printedContent));
    }
    
}
