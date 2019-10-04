/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author DELL
 */
class WriteThread extends Thread{
    private BufferedReader reader;
    private DataOutputStream out;
    private Socket socket;
    private ChatClient client;
    public WriteThread(Socket socket, ChatClient client) {
        this.socket = socket;
        this.client = client;
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(socket.getOutputStream());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void run(){
        
            try{
                out.writeUTF(client.getUserName());
                while(true){
                    String mess = reader.readLine();
                    out.writeUTF(mess);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        
    }
    
    
}
