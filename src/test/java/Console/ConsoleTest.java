package Console;

import Config.TestConfig;
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
    public void executeInvalidCommand(){
        console.execute("");
        assertEquals("Invalid command. Please Try again", printedContent.toString().trim());
    }
    
}
