/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gojek.carparking;

import Utils.Helpers;
import console.Console;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author arab
 */
public class App {
     public static void main(String[] args) throws IOException{
         
        Helpers.welcomeMessage();
        
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = null;
        service= Executors.newFixedThreadPool(coreCount);
            
        Scanner in = new Scanner(System.in);
        while(true){
            
            if(service.isShutdown()){
                 service= Executors.newFixedThreadPool(coreCount);
            }
            
            service.execute(new Console(in.nextLine()));
            service.shutdown();
        }         
    }
}
