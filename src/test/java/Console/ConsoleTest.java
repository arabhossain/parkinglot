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
    
    @Test
    public void executeInvalidCommand(){
        new Thread(new Console(""));
        assertEquals("", printedContent.toString().trim());
    }
    
}
