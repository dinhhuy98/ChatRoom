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
import java.net.Socket;
import java.util.ArrayList;

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
    public void run() {
        try{
            String smg ="["+userName+"]:"+" connected" ;
            toAll(smg);
            while(true){
                String reponse =in.readUTF();
                if(reponse!=null)
                    toAll("["+userName+"] "+reponse);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void toAll(String msg) throws IOException{
        for(int i=0;i<connectionArray.size();i++){
            ClientHandler p = connectionArray.get(i);
            if(p!=this){
                p.out.writeUTF(msg);
            }
                
        }
    }
    
}
