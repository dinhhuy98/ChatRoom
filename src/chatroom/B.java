/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class B implements Runnable{
       private   ArrayList<B> k;

        public B(ArrayList<B> k){
            this.k=k;
        }
        @Override
        
        public void run() {
            while(true){
                System.out.println(k.size());
            }
        }
        
}
