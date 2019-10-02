/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import static Utils.Output.*;
import com.gojek.carparking.ManageParking;
import models.Car;


/**
 *
 * @author arab
 */
public class Console implements Commands, Runnable{
    
    private ManageParking manageParking = new ManageParking();
    private Car car;
    private String command;
    /**
     * Console always print welcome message and application version
     */
    public Console(String command){
        this.command = command;
    }

    public Console() {}
    
    
    /**
     * prepare user input and use as command
     * 
     * @param cmd 
     */
    public void execute(String cmd){
        car = null;
        String[] inputs = cmd.split(" ");
        String _command;
        
        try{
          _command = inputs[0].trim();
        }catch(ArrayIndexOutOfBoundsException e){
            Output("Invalid command");
            Output("");
            return;
        }
        
        switch(_command){
            case CREATE_PARKING:
                try{
                    manageParking.addressParking(Integer.parseInt(inputs[1]));
                }catch(ArrayIndexOutOfBoundsException e){
                    Output("Parking slot capacity is required");
                }
                Output("");                
                break;
            case PARK:
                String registration_number = null, color = null;
                try{
                    registration_number = inputs[1].trim();
                }catch(ArrayIndexOutOfBoundsException e){
                    Output("Registration number is required");
                    return;
                }  
                
                try{
                    color = inputs[2].trim();
                }catch(ArrayIndexOutOfBoundsException e){
                     Output("Car Color is required");
                     return;
                }  
                
               manageParking.parkCar(new Car(registration_number, color));
               Output("");
               break;
            case CARE_LEAVE:
                try{
                    manageParking.leaveCar(Integer.parseInt(inputs[1]));
                }catch(ArrayIndexOutOfBoundsException e){
                    Output("Slot number is required");
                }
                
                Output("");
                break;
            case PARKING_STATUS:
                manageParking.parkingStatus();
                Output("");
                break;
            case GET_REG_OF_CARS_BY_COLOR:
                 try{
                    manageParking.getRegOfCarsByColor(inputs[1].trim());
                }catch(ArrayIndexOutOfBoundsException e){
                    Output("Car color is required");
                } 
              
                Output("");
                break;
            case GET_SLOTS_NUMBER_OF_CARS_BY_COLOR:
                 try{
                    manageParking.getSlotsOfCarsByColor(inputs[1].trim());
                }catch(ArrayIndexOutOfBoundsException e){
                    Output("Car registration number is required");
                } 
              
                Output("");
                break;
            case GET_SLOTS_BY_REG:
                try{
                    manageParking.getSlotsByReg(inputs[1].trim());
                }catch(ArrayIndexOutOfBoundsException e){
                    Output("Car registration number is required");
                } 
                Output("");
                break;
            case EXIT:
                System.exit(0);
                break;
            default:
                 Output("Command not found. Please Try again");
                 Output("");
                break;
            
        }
    }

    @Override
    public void run() {
        this.execute(this.command);
    }
   
}
