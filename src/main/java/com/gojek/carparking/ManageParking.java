/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gojek.carparking;

import static Utils.Output.*;
import java.util.ArrayList;
import java.util.List;
import models.ParkingZone;

/**
 *
 * @author arab
 */
public class ManageParking {
    /**
     * Static parking capacity
     */
    private static int capacity = 0;
    
    /**
     * Static list of parking zone
    */
    private static List<ParkingZone> parkingZone = new ArrayList<ParkingZone>();
    
    
    /**
     * 
     * Create parking lot with number of car holding capacity
     * 
     * @param capacity 
     */
    public void addressParking(int capacity){
       ManageParking.capacity = capacity;
       for(int count = 0; count < capacity; count++){
           ParkingZone newPark = new ParkingZone(count, null);
           parkingZone.add(newPark);
       }
        Output("Created a parking lot with "+capacity+" slots");
       
    }
    
    /**
     * Parking lots details status view
     */
    public void parkingStatus(){
        //check if parking lot is created
        if(!this.isParkingInit()){
            return;
        }
        
        //check if at least a car is parked, print details each of them
        if(this.carParked() > 0){
            Output("Slot No. \t\t Registration No \t\t color");
            for(ParkingZone slot : parkingZone){
                if(slot.getCar() != null){
                    Output(slot.getAddress()+1+" \t\t\t "+slot.getCar().getRegistation_number()+" \t\t\t"+slot.getCar().getColor());
                }
            }
            return;
        }
        
        //else show no car is being parked yet
        Output("All slots are free");
    }
    
    
    /**
     * check how many cars in the parking lot
     * 
     * @return int
     */
    private int carParked(){      
        int parked = 0;
        for(ParkingZone slot : parkingZone){
            if(slot.getCar() != null){
                parked++;
            }
        }
        return parked;
    }
    
    
    /**
     * Check parking lot slots are available or not
     * 
     * @return true | false
     */
    private boolean hasSlotsAvaiable(){   
        if(!this.isParkingInit()){
            return false;
        }
        return (capacity - this.carParked()) > 0 ? true : false;
    }
    
    /**
     * check if parking lot is created or not
     * 
     * @return true | false
     */
    private boolean isParkingInit(){
         if(capacity <= 0){
            Output("Please init parking capacity");
            return false;
        }
         
       return true; 
    }
}
