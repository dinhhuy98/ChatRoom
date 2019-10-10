/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author DELL
 */
class ReadThread extends Thread{
    private DataInputStream in;
    private Socket socket;
    private ChatClient client;
    public ReadThread(Socket socket, ChatClient client) {
        this.socket=socket;
        this.client=client;
        try{
            in = new DataInputStream(socket.getInputStream());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void run(){
            try{
                while(true){
                    String respone = in.readUTF();
                    if(respone!=null && respone!="#?connection?")
                        System.out.println(respone);
                 
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        
    }
    
}
