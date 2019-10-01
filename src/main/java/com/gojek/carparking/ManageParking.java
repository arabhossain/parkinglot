/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gojek.carparking;

import static Utils.Output.*;
import java.util.ArrayList;
import java.util.List;
import models.Car;
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
       this.capacity = capacity;
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
                    Output(slot.getAddress()+1+" \t\t\t "+slot.getCar().getRegistation_number()+" \t\t\t\t"+slot.getCar().getColor());
                }
            }
            return;
        }
        
        //else show no car is being parked yet
        Output("All slots are free");
    }

    /**
     * Park a car to the parking lot
     * 
     * @param car 
     */
    public void parkCar(Car car){
        
        if(!this.isParkingInit()){
            return;
        }
         
        //check if available slot is there and park
        if(this.hasSlotsAvaiable()){
            int slots = 0;
            for(ParkingZone slot : parkingZone){
                if(slot.getCar() == null){
                    parkingZone.get(slots).setCar(car);
                    Output("Allocated slot number:"+ (slots+1));
                    return;          
                }
                slots++;
           }
        }else{
            Output("Sorry, parking lot is full");
        }
    }
    
    /**
     * leave car from n number slot
     * 
     * @param slot 
     */
    public void leaveCar(int slot){
        
         if(!this.isParkingInit()){
            return;
        }
        
        //check if at least a car in parking lot
        if(this.carParked() > 0){
           ParkingZone zone = null;
           
           //try to find the slot
            try{
                zone = parkingZone.get(slot-1);
            }catch(IndexOutOfBoundsException e){
                 Output("Invalid slot number : "+(slot)+"");
                 return;
            }
            
            //only when the car is found free the slot
           if(zone.getCar() != null){
               parkingZone.get(slot-1).setCar(null);
               Output("Slot number "+(slot)+" is free");
               return;
           }
        }
        
        Output("No car in Slot number "+(slot)+"");
    }
    
    /**
     * Search all the cars with white color and print its registration number
     */
    public void getRegOfWhiteCars(){
        if(!this.isParkingInit()){
            return;
        }
        if(this.carParked() > 0){
            String regstrations = "";
            for(ParkingZone slot : parkingZone){
                String color = slot.getCar().getColor();
                if(color.toLowerCase().equals("white")){
                    regstrations += slot.getCar().getRegistation_number()+", ";
                }                
            }
            if (regstrations.endsWith(", ")) {
                regstrations = regstrations.substring(0, regstrations.length() - 2);
            }
            Output(regstrations);
            return;
        }
        
        Output("White color cars are not found now");
    }
    
    
    /**
     * Search all the cars with white color and print its slot address
     */
    public void getSlotsOfWhiteCars(){
        if(!this.isParkingInit()){
            return;
        }
        if(this.carParked() > 0){
            String regstrations = "";
            for(ParkingZone slot : parkingZone){
                String color = slot.getCar().getColor();
                if(color.toLowerCase().equals("white")){
                    regstrations += slot.getAddress()+", ";
                }                
            }
            Output(regstrations);
            return;
        }
        
        Output("White color cars are not found now");
    }
    
    
     /**
     * Search all the cars by registration number and print slot address
     * @param registration
     */
    public void getSlotsByReg(String registration){
        if(!this.isParkingInit()){
            return;
        }
        if(this.carParked() > 0){
            for(ParkingZone slot : parkingZone){
                String color = slot.getCar().getColor();
                if(color.toLowerCase().equals(registration)){
                    Output(slot.getAddress());
                    return;
                }                
            }
        }
        
        Output("Not found");
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
