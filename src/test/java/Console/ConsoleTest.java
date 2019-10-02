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
        console.execute(" ");
        assertEquals("Invalid command", printedContent.toString().trim());
    }
    
    @Test
    public void executeNotFoundCommand(){
        console.execute("buy me a car");
        assertEquals("Command not found. Please Try again", printedContent.toString().trim());
    }
    
    @Test
    public void executeValidCommand(){
        console.execute("create_parking_lot 5");
        assertEquals("Created a parking lot with 5 slots", printedContent.toString().trim());
    }
    
}
