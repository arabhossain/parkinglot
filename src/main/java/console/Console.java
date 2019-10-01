/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import Configs.Configs;
import static Utils.Output.*;
import com.gojek.carparking.ManageParking;
import models.Car;


/**
 *
 * @author arab
 */
public class Console implements Commands{
    
    private ManageParking manageParking = new ManageParking();
    private Car car;
    
    /**
     * Console always print welcome message and application version
     */
    public Console(){
        Output(Configs.WELCOME_MESSAGE+" "+Configs.APP_VERSION+"!");
        Output("\n");
    }
    
    
    /**
     * prepare user input and use as command
     * 
     * @param cmd 
     */
    public void execute(String cmd){
        car = null;
        String[] inputs = cmd.split(" ");
        String command;
        
        try{
          command = inputs[0];
        }catch(ArrayIndexOutOfBoundsException e){
            Output("Invalid command");
            Output("");
            return;
        }
        
        switch(command){
            case CREATE_PARKING:
                try{
                    manageParking.addressParking(Integer.parseInt(inputs[1]));
                }catch(ArrayIndexOutOfBoundsException e){
                    Output("Parking slot capacity is required");
                }
                Output("");                
                break;
            case EXIT:
                System.exit(0);
                break;
            default:
                 Output("Invalid command. Please Try again");
                 Output("");
                break;
            
        }
    }
   
}
