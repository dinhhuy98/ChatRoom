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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
class WriteThread extends Thread{
    private BufferedReader reader;
    private DataOutputStream out;
    private Socket socket;
    private ChatClientGUI clientGUI;
    private String userName;
    public WriteThread(Socket socket, ChatClientGUI clientGUI, String userName) {
        this.socket = socket;
        this.clientGUI = clientGUI;
        this.userName=userName;
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(socket.getOutputStream());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void run(){
        
            try{
                out.writeUTF(this.userName);
                while(true){
                   // String mess = reader.readLine();
                    String mess = clientGUI.getInputTA().getText();
                   // clientGUI.getMessageTA().append(mess+"\n");
                    out.writeUTF(mess);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        
    }
    public void write(String mess){
        try {
            out.writeUTF(mess);
        } catch (IOException ex) {
            Logger.getLogger(WriteThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
