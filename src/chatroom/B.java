/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DELL
 */
public class B extends Thread{
       
       
        public B(){
            while(true){
                System.out.println(ChatRoom.b);
                ChatRoom.add();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(B.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        public static void main(String[] args) {
            B f = new B();
            f.start();
         
            
    }
   }

       
