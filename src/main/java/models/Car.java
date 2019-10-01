/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car.parking.models;

/**
 *
 * @author arab
 */
public class Car {
    private String registation_number, color;

    public Car(){}
    
    public Car(String registation_number, String color) {
        this.registation_number = registation_number;
        this.color = color;
    }

    public String getRegistation_number() {
        return registation_number;
    }

    public void setRegistation_number(String registation_number) {
        this.registation_number = registation_number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString(){
        return "Regestration Number : "+this.registation_number + "\n Color : "+this.color;
    }
}
