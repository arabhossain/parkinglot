/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Config.TestConfig;
import static Utils.Output.*;
import models.Car;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author arab
 */
public class OutputTest extends TestConfig{
       
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
    
     @Test
    public void carOutput(){
        String registation_number = "kha-432-43", color= "white", expectedOutput;
        expectedOutput = "Regestration Number : "+registation_number + "\n Color : "+color;

        Car car = new Car(registation_number, color);
        Output(car);
        assertEquals(expectedOutput, printedContent.toString().trim());
        
        //clean printed contend
        this.restStream();
       
        //getter setter test
        car.setColor(color);
        car.setRegistation_number(registation_number);
        Output(car);
        assertEquals(expectedOutput, printedContent.toString().trim());
    }
}
