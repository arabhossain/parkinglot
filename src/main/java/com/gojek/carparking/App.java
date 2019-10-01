/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gojek.carparking;

import Utils.Helpers;
import console.Console;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author arab
 */
public class App {
     public static void main(String[] args){
       
        Helpers.welcome_message();
        
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
            
        Scanner in = new Scanner(System.in);
        while(true){
            service.execute(new Console(in.nextLine()));
        }          
    }
}
