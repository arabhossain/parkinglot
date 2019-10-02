/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Config.TestConfig;
import com.gojek.carparking.ManageParking;
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

        //create parking and again check status
        String expectedResult = "Please create a parking lot";
        this.manageParking.parkingStatus();
        assertEquals(expectedResult, printedContent.toString().trim());
    } 
}
