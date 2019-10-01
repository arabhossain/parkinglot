/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import models.Car;

/**
 *
 * @author arab
 */
public class Output {
 
    static public void Output (String message){
        System.out.println(message);
    }
    
    static public void Output(int message){
        System.out.println(message);
    }
    
     static public void Output(Car car){
        System.out.println(car.toString());
    }
}
