package Console;

import Config.TestConfig;
import static Utils.Output.*;
import console.Console;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author arab
 */
public class ConsoleTest extends TestConfig{
    Console console = new Console();
    
    @Test
    public void execute(){
        Output("TestString");
        assertEquals("TestString", printedContent.toString().trim());
    }
}
