/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Config.TestConfig;
import com.gojek.carparking.ManageParking;
import models.Car;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author arab
 */
public class ManageParkingTest extends TestConfig{
    
    @Test
    public void addressParkingTest(){
        String expectedResult = "Created a parking lot with 2 slots";
        this.manageParking.addressParking(2);
        assertEquals(expectedResult, printedContent.toString().trim());
    } 
    
    @Test
    public void parkingStatusTest(){

        //Expected Result
        String expectedResult = "Slot No. \t\t Registration No \t\t color\n" +
                                "1 \t\t\t reg-1 \t\t\t\twhite\n" +
                                "2 \t\t\t reg-2 \t\t\t\tblack";
        
        //create parking lot and park cars
        this.manageParking.addressParking(2);
        
        //test park
        this.manageParking.parkCar(new Car("reg-1", "white"));
        this.manageParking.parkCar(new Car("reg-2", "black"));
        
        //rest output stream
        this.restStream();
        
        //
        this.manageParking.parkingStatus();
        assertEquals(expectedResult, printedContent.toString().trim());
        
        //rest parking for not to intarupt with others
        this.manageParking.restParking();
        
    } 
    
    
    @Test
    public void getSlotsOfCarsByColorTest(){
         //Expected Result
        String expectedResult = "1";
        
        //create parking lot and park cars
        this.manageParking.addressParking(2);
        
        //test park
        this.manageParking.parkCar(new Car("reg-1", "white"));
        this.manageParking.parkCar(new Car("reg-2", "black"));
        
        this.restStream();
        
        this.manageParking.getSlotsOfCarsByColor("white");
        assertEquals(expectedResult, printedContent.toString().trim());
    }
    
    
    @Test
    public void getRegOfCarsByColorTest(){
         //Expected Result
        String expectedResult = "reg-1";
        
        //create parking lot and park cars
        this.manageParking.addressParking(2);
        
        //test park
        this.manageParking.parkCar(new Car("reg-1", "white"));
        this.manageParking.parkCar(new Car("reg-2", "black"));
        
        this.restStream();
        
        this.manageParking.getRegOfCarsByColor("white");
        assertEquals(expectedResult, printedContent.toString().trim());
    }
    
    @Test
    public void leaveCarTest(){
         //Expected Result
        String expectedResult = "Slot number 2 is free";
        
        //create parking lot and park cars
        this.manageParking.addressParking(2);
        
        //test park
        this.manageParking.parkCar(new Car("reg-1", "white"));
        this.manageParking.parkCar(new Car("reg-2", "black"));
        
        this.restStream();
        
        this.manageParking.leaveCar(2);
        assertEquals(expectedResult, printedContent.toString().trim());
    }
       
    
}
