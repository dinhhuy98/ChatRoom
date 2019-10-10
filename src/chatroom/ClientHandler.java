/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ClientHandler implements Runnable {
    private ArrayList<ClientHandler> connectionArray = new ArrayList<ClientHandler>();
    private String userName;
    private Socket socket;
    private BufferedReader reader ;
    private DataOutputStream out ;
    private DataInputStream in ;

    ClientHandler(Socket socket, ArrayList<ClientHandler> connectionArray, String user) throws IOException{
        this.socket=socket;
        this.userName=user;
        this.connectionArray=connectionArray;
        reader = new BufferedReader(new InputStreamReader(System.in));
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
    }
    @Override
    public void run(){
        try{
            //checkConnection();
            String smg ="["+userName+"]:"+" connected" ;
            toAll(smg);
            
            while(true){
               // checkConnection();
                String reponse =in.readUTF();
                System.out.println("["+userName+"] "+reponse);
                if(reponse!=null)
                    toAll("["+userName+"] "+reponse);
               
               // toAll(String.valueOf(connectionArray.size()+1));
                
            }
        }catch(IOException e){
            String userN = this.userName;
            connectionArray.remove(this);
            System.out.println(userN + " is disconnected!");
            toAll(userN + " is disconnected!");
         //   try {
             //   checkConnection();
        //    } catch (IOException ex) {
        //        System.out.println("bb");
        //   }
          
        }
    }
    
    public synchronized void toAll(String msg){
        for(int i=0;i<connectionArray.size();i++){
            ClientHandler p = connectionArray.get(i);
            String userN = p.userName;
            if(p!=this){
                try {
                    p.out.writeUTF(msg);
                } catch (IOException ex) {
                    connectionArray.remove(p);
                    System.out.println(userN + " is disconnected!");
                    toAll(userN + " is disconnected!");
                }
            }
                
        }
    }
    
}
