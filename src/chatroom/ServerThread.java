/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author DELL
 */
public class ServerThread extends Thread {
    private Socket socket;
    private String userName;
    public ServerThread(Socket socket, String userName){
        this.socket=socket;
        this.userName=userName;
    }
    public void run(){
        System.out.println(socket.getLocalAddress().getHostName()+" is connected!");
        
    }
   
}
