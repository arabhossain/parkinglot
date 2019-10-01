/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Configs.Configs;
import static Utils.Output.Output;

/**
 *
 * @author arab
 */
public class Helpers {
    
    public static void welcome_message(){
        Output(Configs.WELCOME_MESSAGE+" "+Configs.APP_VERSION+"!");
        Output("Type exit to close the program.");
        Output("Please enter your command.\n");
    }
}
