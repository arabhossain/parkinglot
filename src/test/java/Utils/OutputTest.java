/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import static Utils.Output.Output;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author arab
 */
public class OutputTest {
    private final ByteArrayOutputStream printedContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
	System.setOut(new PrintStream(printedContent));
    }

    @After
    public void cleanUpStreams() {
	System.setOut(null);
    }
    
    @Test
    public void StringOutput(){
        Output("TestString");
        assertEquals("TestString", printedContent.toString().trim());
    }
    
    @Test
    public void numericOutput(){
        Output(3);
        assertEquals(3, Integer.parseInt(printedContent.toString().trim()));
    }
    
}
