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
public class ChatRoom {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         ArrayList<B> k = new ArrayList<>();
         B p= new B(k);
         k.add(p);
         new Thread(p).start();
    }
}
