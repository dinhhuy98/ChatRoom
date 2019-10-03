/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

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
        int i=1;
        add(i);
        System.out.println(i);
    }
    public static void add( int i){
        i+=3;
    }
}
