/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

/**
 *
 * @author arab
 */
public interface Commands {
   
	public final String CREATE_PARKING = "create_parking_lot";
	public final String PARK = "park";
	public final String CARE_LEAVE = "leave";
	public final String PARKING_STATUS = "status";
	public final String GET_REG_OF_CARS_BY_COLOR = "registration_numbers_for_cars_with_colour";
	public final String GET_SLOTS_NUMBER_OF_CARS_BY_COLOR = "slot_numbers_for_cars_with_colour";
	public final String GET_SLOTS_BY_REG = "slot_number_for_registration_number";
        public final String EXIT = "exit";

}
