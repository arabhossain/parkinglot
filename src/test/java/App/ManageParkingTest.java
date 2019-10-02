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
    private final ManageParking manageParking;
   
    public ManageParkingTest() {
        this.manageParking = new ManageParking();
    }
    
    @Test
    public void addressParkingTest(){
        String expectedResult = "Created a parking lot with 2 slots";
        this.manageParking.addressParking(2);
        assertEquals(expectedResult, printedContent.toString().trim());
    }
    

    
    @Test
    public void parkingStatusTest(){

        //Expected Result
        String expectedResult = "Slot No. 		 Registration No 		 color\n" +
                                "1 			 reg-1 				white\n" +
                                "2 			 reg-2 				black";
        
        //create parking lot and park cars
        this.manageParking.addressParking(2);
        this.manageParking.parkCar(new Car("reg-1", "white"));
        this.manageParking.parkCar(new Car("reg-2", "black"));
        
        //rest output stream
        this.restStream();
        
        //
        this.manageParking.parkingStatus();
        assertEquals(expectedResult, printedContent.toString().trim());
    } 
    
}
