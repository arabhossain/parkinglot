/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Configs.Configs;
import static Utils.Output.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author arab
 */
public class Helpers {
    
    public static void welcomeMessage(){
        Output(Configs.WELCOME_MESSAGE+" "+Configs.APP_VERSION+"!");
        Output("Type exit to close the program.");
        Output("Please enter your command.\n");
    }
    
    public static Scanner readFile(String fileUrl){
        
        try {
            File file = new File(fileUrl); 
            if(file.exists() && !file.isDirectory()) {
                Scanner sc = new Scanner(file); 
                return sc;
            }
        } catch (FileNotFoundException ex) {
            Output(ex.getMessage());
        }
        
        return null;
    }
    
}
