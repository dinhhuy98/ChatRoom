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
public class ChatClient {
    private String hostname;
    private int port;
    private String userName;

    public ChatClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }
    public Socket connect() throws IOException{
        
            Socket socket = new Socket(hostname,port);
            System.out.println("Connected to the chat server");
         //   new WriteThread(socket, this).start();
         //   new ReadThread(socket, this).start();
            return socket;
            
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
