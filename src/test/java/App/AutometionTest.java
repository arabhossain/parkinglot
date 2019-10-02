/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Config.TestConfig;
import Utils.Helpers;
import console.Console;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author arab
 */
public class AutometionTest extends TestConfig{

    @Test
    public void AppTest(){

        //define test file path
        String testFile = System.getProperty("user.dir")+"/fixtures/file_input.txt";
        
        //Read data form file
        Scanner reader = Helpers.readFile(testFile);
        
        //pass all the command lines loop through console object
        Console console = new Console();
        while(reader.hasNextLine()){
            console.execute(reader.nextLine().trim()); 
        }
        
        //
        assertEquals(this.getExpectedResult(), this.printedContent.toString().trim());
       
    }
    
    private String getExpectedResult(){
        return "Created a parking lot with 6 slots\n" +
                "\n" +
                "Allocated slot number:1\n" +
                "\n" +
                "Allocated slot number:2\n" +
                "\n" +
                "Allocated slot number:3\n" +
                "\n" +
                "Allocated slot number:4\n" +
                "\n" +
                "Allocated slot number:5\n" +
                "\n" +
                "Allocated slot number:6\n" +
                "\n" +
                "Slot number 4 is free\n" +
                "\n" +
                "Slot No. 		 Registration No 		 color\n" +
                "1 			 KA-01-HH-1234 				White\n" +
                "2 			 KA-01-HH-9999 				White\n" +
                "3 			 KA-01-BB-0001 				Black\n" +
                "5 			 KA-01-HH-2701 				Blue\n" +
                "6 			 KA-01-HH-3141 				Black\n" +
                "\n" +
                "Allocated slot number:4\n" +
                "\n" +
                "Sorry, parking lot is full\n" +
                "\n" +
                "KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333\n" +
                "\n" +
                "1, 2, 4\n" +
                "\n" +
                "6\n" +
                "\n" +
                "Not found";
    }
}
